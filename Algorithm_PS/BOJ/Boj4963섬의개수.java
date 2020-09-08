package BOJ;

import java.util.Scanner;

public class Boj4963섬의개수 {
	
	static int W, H;
	static int[][] map;
	static boolean[][] visit;
	
	static int[] di = {0,0,-1,1,-1,1,-1,1};
	static int[] dj = {1,-1,0,0,-1,1,1,-1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			W = sc.nextInt(); // 열
			H = sc.nextInt(); // 행
			if(W==0 && H==0) break;
			
			map = new int[H][W];
			visit = new boolean[H][W];
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int cnt = 0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j] == 1 && !visit[i][j]) {
						cnt ++;
						dfs(i, j);
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	static void dfs(int i, int j) {
		visit[i][j] = true;
		
		for(int d=0; d<8; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0 && ni<H && nj>=0 && nj<W 
					&& map[ni][nj]==1 && !visit[ni][nj]) {
				dfs(ni,nj);
			}
		}
	}
}
