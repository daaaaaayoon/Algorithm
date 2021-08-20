package swea;

import java.util.Scanner;

public class Swea1861정사각형방 {
	
	static int N, cnt;
	static int cans, rans;
	static int[][] rooms;
	static boolean[][] visit;
	
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			
			N = sc.nextInt();
			rooms = new int[N][N];
			rans = Integer.MAX_VALUE;
			cans = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					rooms[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					cnt = 0;
					dfs(i, j);
					if(cnt > cans) {
						cans = cnt;
						rans = rooms[i][j];
					}else if(cnt == cans && rans > rooms[i][j]) {
						rans = rooms[i][j];
					}
				}
			}
			
			System.out.println("#"+tc+" "+rans+" "+cans);
			
		}
		
	}
	
	static void dfs(int i, int j) {
		cnt++;
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0 && ni<N && nj>=0 && nj<N && rooms[ni][nj]==rooms[i][j]+1) {
				dfs(ni, nj);
			}
		}
	}
}
