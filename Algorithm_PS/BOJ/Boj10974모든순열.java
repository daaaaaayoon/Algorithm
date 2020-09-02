package BOJ;

import java.util.Scanner;

public class Boj10974모든순열 {
	
	static int N; // 1~N까지의 수
	static int[] ans; // 만들어진 순열을 저장할 배열
	static boolean[] used; // 순열을 만드는데 숫자가 쓰였는지 아닌지를 판단하기위한 배열
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		ans = new int[N];
		used = new boolean[N+1];
		
		permutation(0); // 0번째 자리부터 정하러간다.
		
	}
	
	static void permutation(int cnt) {
		if(cnt == N) { // 순열이 하나 만들어졌다면
			for(int i=0; i<N; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1; i<=N; i++) {
			if(!used[i]) {
				used[i] = true;
				ans[cnt] = i;
				permutation(cnt+1);
				used[i] = false;
			}
		}
	}
}
