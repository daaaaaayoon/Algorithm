package boj;

import java.util.Scanner;

public class Boj_15652_N과M4 {
	
	static int N, M;
	static int[] ans;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		ans = new int[M];
		sb = new StringBuilder();
		
		comb(0, 1);
		
		System.out.println(sb.toString());
	}
	
	static void comb(int cnt, int start) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(ans[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start; i<=N; i++) {
			ans[cnt] = i;
			comb(cnt+1, i);
		}
	}
}
