package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2206벽부수고이동하기_BFS_쌤 {
	static int N, M; // 행, 열
	static int[][] map;
	static int[][][] visit; // 어떤 좌표 i,j에 벽을 안부수고0, 부수고1 각각 "거리 기록용도"
	// visit 배열을 두개 쓴것이나 다름 없음 => 거리 기록과 동시에 방문여부 기록 용도

	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j] = line[j]-'0';
			}
		}
		
		visit = new int[N][M][2]; // 시작점으로부터 거리를 기록할 배열
		for(int i=0; i<N; i++) { // 초기에는 모든 칸까지의 거리 최대로 잡아놓고 더 작은값 나타나면 갱신해서 움직여야지~~
			for(int j=0; j<M; j++) {
				for(int k=0; k<2; k++) {
					visit[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0, 0));
		visit[0][0][0] = 1; // 출발점에서 거리 일단 1. 여기서 +1 해서 거리가 멀어짐.
		visit[0][0][1] = 1;
		
		while(!queue.isEmpty()) { // 방문 가능 좌표가 있다면.
			Point now = queue.poll();
			
			for(int d=0; d<4; d++) {
				int ni = now.i + di[d];
				int nj = now.j + dj[d];
				
				if(!check(ni, nj)) continue;
				
				if(map[ni][nj]==0 && visit[ni][nj][now.wall] > visit[now.i][now.j][now.wall]+1) {
					// 옆칸 ni, nj가 벽이 아니고, 기존 그칸까지의 거리보다 지금 now찍고 가는게 더 빠른 경우(내가 벽을 부수고왔든 안부수고 왔든)
					visit[ni][nj][now.wall] = visit[now.i][now.j][now.wall]+1;
					queue.add(new Point(ni, nj, now.wall));
				}else if(map[ni][nj]==1 && now.wall==0) {
					// 옆칸 ni, nj가 벽일때는 현재 내가 벽을 부순적이 없는 상태여야함.
					visit[ni][nj][1] = visit[now.i][now.j][0] + 1;
					queue.add(new Point(ni, nj, 1));
				}
			}
		}
		// 벽을 부수고 가는 경우와 아닌 경우의 최단거리를 비교하게 됨.
		int ans = Math.min(visit[N-1][M-1][0], visit[N-1][M-1][1]);
		System.out.println(ans==Integer.MAX_VALUE? -1: ans);
	}
	
	// 그냥 범위 체크 따로 떼어버림
	static boolean check(int i, int j) {
		if(i>=0 && i<N && j>=0 && j<M)
			return true;
		return false;
	}
	
	static class Point {
		int i, j, wall; // 벽을 부순 횟수 = 0 or 1

		Point(int i, int j, int wall) {
			this.i = i;
			this.j = j;
			this.wall = wall;
		}
	}
}