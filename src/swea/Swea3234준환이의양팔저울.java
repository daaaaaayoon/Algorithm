package swea;

import java.util.Scanner;

public class Swea3234준환이의양팔저울 {
	
	static int N, totalSum, ans;
	static int[] input;
	static boolean[] used;
	
	static int[] facto;
	static int[] pow;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			
			N = sc.nextInt();
			
			input = new int[N];
			used = new boolean[N];
			
			facto = new int[N+1];
			pow = new int[N+1];
			facto[0] = facto[1] = pow[0] = 1;
			totalSum = 0;
			ans = 0;
			
			for(int i=0; i<N; i++) {
				input[i] = sc.nextInt();
				facto[i+1] = facto[i] * (i+1); // 1! ~ 9!
				pow[i+1] = pow[i] * 2; // 2^1 ~ 2^9
				totalSum += input[i];
			}
			
			perm(0, 0, 0, totalSum);
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void perm(int cnt, int leftSum, int rightSum, int remain) {
		
		if(leftSum >= rightSum + remain) {
			ans += pow[N-cnt] * facto[N-cnt];
			return;
		}
		
		if(cnt == N) {
			ans++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!used[i]) {
				used[i] = true;
				perm(cnt+1, leftSum + input[i], rightSum, remain-input[i]);
				if(leftSum >= rightSum + input[i]) {
					perm(cnt+1, leftSum, rightSum+input[i], remain-input[i]);
				}
				used[i] = false;
			}
		}
	}
	
}
