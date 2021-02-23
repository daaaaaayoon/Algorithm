package Boj;

import java.util.Scanner;

public class Boj_2231_분해합 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int ans = Integer.MAX_VALUE;
		int tmp = N;
		while(true) {
			
			if(--tmp <= 0) break;
			
			if(devideAndSum(tmp)+tmp == N) {
				ans = tmp;
			}
			
		}
		System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
		
	}
	
	private static int devideAndSum(int n) {
		
		int sum = 0;
		int num = n;
		while(true) {
			sum += (num%10);
			num /= 10;
			if(num == 0) break;
		}
		return sum;
		
	}
	
}