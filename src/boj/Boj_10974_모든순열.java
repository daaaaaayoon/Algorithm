package boj;

import java.util.Scanner;

public class Boj_10974_모든순열{
	
	static int N;
	static int[] ans;
	static boolean[] used;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		ans = new int[N];
		used = new boolean[N+1];
		
		permutation(0);
		
	}
	
	static void permutation(int cnt) {
		if(cnt == N) {
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
