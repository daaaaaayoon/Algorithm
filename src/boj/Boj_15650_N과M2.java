package boj;

import java.util.Scanner;

public class Boj_15650_N과M2 {
	
	static int N, M;
	static int[] ans;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		ans = new int[M];
		
		combination(0, 1);
	}
	
	static void combination(int cnt, int start) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i<=N; i++) {
			ans[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
}
