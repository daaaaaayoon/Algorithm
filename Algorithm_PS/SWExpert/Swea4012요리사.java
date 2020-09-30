package SWEA;

import java.util.Scanner;

public class Swea4012¿ä¸®»ç {
	
	static int N, ans;
	static int[][] ingre;
	static int[] a, b;
	static boolean[] select;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			N = sc.nextInt();
			
			ingre = new int[N][N];
			a = new int[N/2];
			b = new int[N/2];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					ingre[i][j] = sc.nextInt();
				}
			}
			
			ans = Integer.MAX_VALUE;
			comb(0, 0);
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	
	static void comb(int start, int cnt) {
		if(cnt == N/2) {
			
			select = new boolean[N];
			for(int i=0; i<N/2; i++) {
				select[a[i]] = true;
			}
			for(int i=0, j=0; i<N; i++) {
				if(!select[i]) b[j++] = i;
			}
			
			int sumA = 0;
			for(int i=0; i<N/2; i++) {
				for(int j=i+1; j<N/2; j++) {
					sumA += (ingre[a[i]][a[j]] + ingre[a[j]][a[i]]);
				}
			}
			int sumB = 0;
			for(int i=0; i<N/2; i++) {
				for(int j=i+1; j<N/2; j++) {
					sumB += (ingre[b[i]][b[j]] + ingre[b[j]][b[i]]);
				}
			}
			
			ans = Math.min(Math.abs(sumA-sumB), ans);
			return;
		}
		for(int i=start; i<N; i++) {
			a[cnt] = i;
			comb(i+1, cnt+1);
		}
	}
}
