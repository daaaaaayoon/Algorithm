package BOJ;

import java.util.Scanner;
// ����Լ� ���� => �ð��ʰ�!
public class Boj2747�Ǻ���ġ��_Recursion {
	
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
