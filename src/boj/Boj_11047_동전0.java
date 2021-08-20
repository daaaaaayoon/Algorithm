package boj;

import java.util.Scanner;

public class Boj_11047_동전0 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] coins = new int[N];
		for(int n=0; n<N; n++) {
			coins[n] = sc.nextInt();
		}
		
		int ans = 0;
		for(int n=N-1; n>=0; n--) {
			if(K >= coins[n]) {
				ans += K/coins[n];
				K %= coins[n];
			}
		}
		System.out.println(ans);
	}
	
}
