package boj;

import java.util.Scanner;

public class Boj_2605_줄세우기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		int[] ans = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		
		ans[0] = 1;
		for(int i=1; i<N; i++) {
			
			for(int j=i-1; j>=(i-num[i]); j--) {
				ans[j+1] = ans[j];
			}
			
			ans[i-num[i]] = i+1;
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(ans[i]+" ");
		}
	}
}
