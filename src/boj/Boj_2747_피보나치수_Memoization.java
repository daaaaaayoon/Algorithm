package boj;

import java.util.Scanner;

public class Boj_2747_피보나치수_Memoization {
	
	static int N;
	static long[] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		memo = new long[N+1];
		memo[0] = 0;
		memo[1] = 1;
		
		System.out.println(fibo(N));
	}
	
	static long fibo(int n) {
		if(n >= 2 && memo[n]==0) { 
			memo[n] = fibo(n-1) + fibo(n-2);
		}
		return memo[n];
	}
}
