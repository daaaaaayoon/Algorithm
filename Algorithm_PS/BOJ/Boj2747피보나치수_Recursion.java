package BOJ;

import java.util.Scanner;
// 재귀함수 구현 => 시간초과!
public class Boj2747피보나치수_Recursion {
	
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println(fibo(N));
	}
	
	static int fibo(int n) {
		if(n < 2) return n;
		return fibo(n-1) + fibo(n-2);
	}
}
