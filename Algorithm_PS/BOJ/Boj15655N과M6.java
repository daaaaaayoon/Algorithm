package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Boj15655N과M6 {
	// N개의 자연수 중에서 M개를 고른 수열 + 고른 수열은  오름차순 => 조합
	// 입력받은 숫자로 조합을 만들어 출력하는 문제
	
	static int N, M;
	static int[] input, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		input = new int[N];
		ans = new int[M];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		Arrays.sort(input); // 사전순으로 증가하는 순서로 출력하기 위해서 정렬
		
		comb(0, 0);
		
	}
	
	static void comb(int cnt, int now) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=now; i<N; i++) {
			ans[cnt] = input[i];
			comb(cnt+1, i+1);
		}
	}
}
