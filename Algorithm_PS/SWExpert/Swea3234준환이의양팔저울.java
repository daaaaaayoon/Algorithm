package SWEA;

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
			
			facto = new int[N+1]; // index의 팩토리얼 값을 저장할 배열
			pow = new int[N+1]; // 2^index의 값을 저장할 배열
			facto[0] = facto[1] = pow[0] = 1;
			totalSum = 0;
			ans = 0;
			
			for(int i=0; i<N; i++) {
				input[i] = sc.nextInt();
				facto[i+1] = facto[i] * (i+1); // 1! ~ 9!
				pow[i+1] = pow[i] * 2; // 2^1 ~ 2^9
				totalSum += input[i]; // 추들의 총 무게 합
			}
			
			perm(0, 0, 0, totalSum);
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void perm(int cnt, int leftSum, int rightSum, int remain) {
		
		// 남아있는 추를 오른쪽에 모두 놓아봐도 왼쪽보다 안무거우면 재귀 진행하지말고,
		// 그냥 경우의 수를 구해버리고 return해버리자.
		if(leftSum >= rightSum + remain) {
			// 문제에 나와있듯이, 왼쪽 오른쪽에 놓는 경우 2^n * 순서의 경우 n!
			ans += pow[N-cnt] * facto[N-cnt];
			return;
		}
		
		if(cnt == N) { // 추를 모두 놓아본 경우
			ans++; // 경우의 수 증가
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!used[i]) { // 지금까지 안놓은 추를 놓아볼게
				used[i] = true; // 내 이후의 재귀는 이 추 못써,, 재귀 끝나면 돌려줄게!
				// 왼쪽에 추를 놓는 경우 => 제약이 없다.
				perm(cnt+1, leftSum + input[i], rightSum, remain-input[i]);
				// 오른쪽에 추를 놓는 경우 => 추를 놓아도 왼쪽 이하여야한다.
				if(leftSum >= rightSum + input[i]) {
					perm(cnt+1, leftSum, rightSum+input[i], remain-input[i]);
				}
				used[i] = false; // 재귀 끝났으니 돌려준다!
			}
		}
	}
	
}
