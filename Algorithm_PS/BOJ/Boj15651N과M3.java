package BOJ;

import java.util.Scanner;

public class Boj15651N과M3 {
	
	// 1부터 N까지의 자연수 중에서 M개를 고른 수열
	// 같은 수를 여러번 골라도된다 => 중복 순열
	
	// 순열에서 사용여부를 표시하는 used배열을 제거하면 됨
	
	static int N, M;
	static int[] ans;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		ans = new int[M];
		sb = new StringBuilder();
		
		perm(0); // 0번째의 숫자를 뽑으러 간다.
		
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
