package boj;

import java.util.Scanner;

public class Boj_2468_안전영역 {
	
	static int[][] area;
	static boolean[][] visited;
	static int[] di = {1, -1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int N, max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		area = new int[N][N];
		max=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				area[i][j] = sc.nextInt();
				if(max <= area[i][j]) max = area[i][j];
			}
		}
		int cntMax=0;
		while(true) {
			if(max==0) break;
			int cnt=0; 
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(max <= area[i][j] && !visited[i][j]) {
						dfs(i,j);
						++cnt;
					}
				}
			}// for end
			if(cntMax <= cnt) cntMax = cnt;
			max--;
		}
		System.out.println(cntMax);
	}// main end
	
	static void dfs(int i, int j) {
		visited[i][j] = true;
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
			if(max <= area[ni][nj] && !visited[ni][nj]) dfs(ni, nj);
		}
	}
}