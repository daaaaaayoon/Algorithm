package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2206벽부수고이동하기_BFS_나 {
	
	static int N, M;
	static char[][] map;
	static int[][][] dist;
	static Queue<Point> queue;
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	static class Point{
		int i, j, broken; // 좌표와 벽을 부수었는지 여부 (0: 안부숨, 1: 부숨)
		Point(int i, int j, int broken){
			this.i = i;
			this.j = j;
			this.broken = broken;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N x M
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		dist = new int[N][M][2];
		queue = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		queue.add(new Point(0,0,0));
		dist[0][0][0] = 1;
		
		while(!queue.isEmpty()) {
			
			Point n = queue.poll();
			
			// 가장 먼저 도달한 애가 있으면 최단경로임
			if(n.i==N-1 && n.j==M-1) {
				System.out.println(dist[n.i][n.j][n.broken]);
				return;
			}
			
			for(int d=0; d<4; d++) {
				int ni = n.i + di[d];
				int nj = n.j + dj[d];
				if(ni<0 || ni>=N || nj<0 || nj>=M) continue;
				if(dist[ni][nj][n.broken]!=0) continue;
				if(map[ni][nj] == '0') {
					dist[ni][nj][n.broken] = dist[n.i][n.j][n.broken]+1;
					queue.add(new Point(ni, nj, n.broken));
				}else if(map[ni][nj] == '1' && n.broken==0) {
					dist[ni][nj][1] = dist[n.i][n.j][n.broken]+1;
					queue.add(new Point(ni, nj, 1));
				}
			}
		}
		
		System.out.println(-1);
	}
}
