package BOJ;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2589보물섬 {
	
	static int N, M, ans; // 세로(행) 가로(열) 정답
	static char[][] map;
	static boolean[][] visit;
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0}; 
	static Queue<Point> queue;
	
	static class Point{
		int i; int j; int dist;
		Point(int i, int j, int dist){
			this.i = i;
			this.j = j;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로 - 행
		M = Integer.parseInt(st.nextToken()); // 가로 - 열
		
		map = new char[N][M];
		visit = new boolean[N][M];
		queue = new LinkedList<>();
		ans = 0;
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]=='L') {
					visit = new boolean[N][M];
					bfs(i, j);
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static void bfs(int i, int j) {
		
		queue.add(new Point(i, j, 0));
		visit[i][j] = true;
		
		while(!queue.isEmpty()) {
			
			Point n = queue.poll();
			
			ans = Math.max(ans, n.dist);
			
			for(int d=0; d<4; d++) {
				int ni = n.i + di[d];
				int nj = n.j + dj[d];
				if(ni>=0 && ni<N && nj>=0 && nj<M 
						&& map[ni][nj]=='L' && !visit[ni][nj]) {
					queue.add(new Point(ni, nj, n.dist+1));
					visit[ni][nj] = true;
				}
			}
		}
	}
	
}
