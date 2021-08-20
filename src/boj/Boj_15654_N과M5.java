package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_15654_N과M5 {
	

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
		
		Arrays.sort(input);
		
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
