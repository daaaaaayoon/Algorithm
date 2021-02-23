package Boj;

import java.util.Scanner;

public class Boj_2798_∫Ì∑¢¿Ë {
	
	static int N, M, ans;
	static int[] cards;
	static int[] selected;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		cards = new int[N];
		selected = new int[3];
		ans = 0;
		
		for(int i=0; i<N; i++) {
			cards[i] = sc.nextInt();
		}
		
		comb(0, 0, 0);
		System.out.println(ans);
		
	}

	static void comb(int cnt, int a, int sum) {
		
		if(sum > M) return;
		
		if(cnt == 3) {
			if(sum <= M && ans < sum) {
				ans = sum;
			}
			return;
		}
		
		for(int i=a; i<N; i++) {
			selected[cnt] = cards[i];
			comb(cnt+1, i+1, sum+selected[cnt]);
		}
		
	}
	
}
