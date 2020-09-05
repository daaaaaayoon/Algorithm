package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Boj15654N과M5 {
	
	// N개의 자연수 중에서 M개를 고른 수열
	// 입력받은 숫자로 순열을 만들어 출력하는 문제
	
	static int N, M;
	static int[] input, ans;
	static boolean[] select;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		input = new int[N];
		select = new boolean[N];
		ans = new int[M];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		Arrays.sort(input); // 사전순으로 증가하는 순서로 출력하기 위해서 정렬
		
		perm(0);
		
	}
	
	static void perm(int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0; i<N; i++) {
			if(!select[i]) {
				select[i] = true;
				ans[cnt] = input[i];
				perm(cnt+1);
				select[i] = false;
			}
		}
	}
}
