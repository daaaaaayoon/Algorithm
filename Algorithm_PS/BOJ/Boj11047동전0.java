package BOJ;

import java.util.Scanner;

public class Boj11047동전0 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] coins = new int[N];
		for(int n=0; n<N; n++) {
			coins[n] = sc.nextInt();
		}
		
		int ans = 0; // 동전 개수의 최솟값
		// 동전의 개수가 최소가 되기 위해 가장 큰 단위부터 시작한다
		for(int n=N-1; n>=0; n--) {
			// K가 동전의 가치보다 크거나 같다면,
			if(K >= coins[n]) {
				// K를 동전의 가치로 나눈 몫만큼 ans 증가
				ans += K/coins[n];
				// K를 동전의 가치로 나눈 나머지를 K에 넣기
				K %= coins[n];
			}
		}
		System.out.println(ans);
	}
	
}
