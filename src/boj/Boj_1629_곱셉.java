package boj;

import java.util.Scanner;

public class Boj_1629_곱셉 {

	static int A, B, C;
	static long val;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		
		System.out.println(func(A, B, C));
	}
	
	static long func(int a, int b, int c){
		if(b == 1) return a % c; // a�� c���� Ŭ ���� ����
		val = func(a, b/2, c);
		val = val  * val % c;
		if(b%2 == 0) return val; // a^(2n) = a^n * a^n
		return val * a % c; // a^(2n+1) = a^n * a^n * a
	}
	
}
