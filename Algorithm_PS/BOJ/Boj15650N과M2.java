package BOJ;

import java.util.Scanner;

public class Boj15650N과M2 {
	
	// 1부터 N까지의 자연수 중에서 중복없이 M개를 고른 수열
	// 고른 수열은 오름차순 => 조합!
	static int N, M;
	static int[] ans; // 완성된 조합을 넣을 배열
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		ans = new int[M];
		
		// 0번째의 숫자를 뽑으러 간다. 1번부터 뽑을차례!
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
			// 다음 숫자를 뽑으러가는데, 지금 뽑은 것보다 다음 숫자를 뽑아야해 :)
			combination(cnt+1, i+1); 
		}
	}
}
