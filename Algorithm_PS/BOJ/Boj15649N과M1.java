package BOJ;

import java.util.Scanner;

public class Boj15649N과M1 {
	
	// 1부터 N까지의 자연수 중에서 중복 없이 M개를 고른 수열
	// nPr
	static int N, M;
	static int[] ans; // 만들어진 수열을 담을 배열
	static boolean[] used; // 순열 중 선택된(쓰인)숫자를 구분하기 위함
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		ans = new int[M]; // M개의 숫자를 담을 것임
		used = new boolean[N+1]; // 인덱스를 사용할 것임 (1~N)
		
		permutation(0); // 0번째 숫자부터 정하러 간다.
	}
	
	static void permutation(int cnt) {
		if(cnt == M) { // N개를 모두 선택했다!
			for(int i=0; i<M; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1; i<=N; i++) {
			if(!used[i]) {
				used[i] = true;
				ans[cnt] = i;
				permutation(cnt+1); // 다음 순열을 구하러 간다.
				used[i] = false;
			}
		}
	}
}
