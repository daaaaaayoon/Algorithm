package boj;

import java.math.BigInteger;
import java.util.Scanner;

public class Boj_1914_하노이탑 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		BigInteger bi = new BigInteger("2");
		BigInteger c = bi.pow(N).subtract(BigInteger.ONE);
		System.out.println(c);

		if(N <= 20) {
			func(N, 1, 3);
		}
	}

	static void func(int n, int a, int b) {

		if (n == 1) {
			System.out.println(a + " " + b);
			return;
		}
		func(n - 1, a, 6 - a - b);
		System.out.println(a + " " + b);
		func(n - 1, 6 - a - b, b);

	}
}