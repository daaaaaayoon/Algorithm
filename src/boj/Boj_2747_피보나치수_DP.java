package boj;

import java.util.Scanner;

public class Boj_2747_피보나치수_DP {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] D = new int[N+1];
		
		D[0] = 0;
		D[1] = 1;
		for(int i=2; i<=N; i++) {
			D[i] = D[i-1] + D[i-2];
		}
		System.out.println(D[N]);
		
	}
}
