package boj;

import java.util.Scanner;

public class Boj_17070_파이프옮기기1 {
	
	static int N, ans;
	static int[][] house;
	static int[] di = {0, 1, 1};
	static int[] dj = {1, 0, 1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		house = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				house[i][j] = sc.nextInt();
			}
		}
		
		move(1, 2, 0);
		System.out.println(ans);
	}
	
	static void move(int i, int j, int dir) {
		
		if(i==N && j==N) {
			ans++;
			return;
		}
		
		for(int d=0; d<3; d++) {
			
			if(dir==0 && d==1) continue;
			if(dir==1 && d==0) continue;
			
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(ni>=1 && ni<=N && nj>=1 && nj<=N
					&& house[ni][nj]!=1) {
				
				if(d==2) {
					if(house[ni-1][nj]!=1 && house[ni][nj-1]!=1) {
						move(ni, nj, d);
					}
				} else {
					move(ni, nj, d);
				}
				
			}
				
		}
	}
	
}
