package boj;

import java.util.Scanner;

public class Boj_15651_N과M3 {
	
	static int N, M;
	static int[] ans;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		ans = new int[M];
		sb = new StringBuilder();
		
		perm(0);
		
		System.out.println(sb.toString());
	}
	
	static void perm(int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(ans[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=1; i<=N; i++) {
			ans[cnt] = i;
			perm(cnt+1);
		}
	}
}
