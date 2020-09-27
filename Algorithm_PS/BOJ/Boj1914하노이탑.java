package BOJ;

import java.math.BigInteger;
import java.util.Scanner;

public class Boj1914하노이탑 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 원반의 개수

		// N이 20 초과인 경우에는 if문 들어가지 않음
		BigInteger bi = new BigInteger("2"); // 2로 초기화
		BigInteger c = bi.pow(N).subtract(BigInteger.ONE); // N승-1
		System.out.println(c);

		// N이 20 이하인 경우
		if(N <= 20) {
			func(N, 1, 3);
		}
	}

	static void func(int n, int a, int b) {

		if (n == 1) {
			System.out.println(a + " " + b);
			return;
		}
		func(n - 1, a, 6 - a - b); // n-1개의 원반을 목표장대가 아닌 곳으로 옮겨둔 후,
		System.out.println(a + " " + b); // n번째 원반을 목표장대로 옮긴다.
		func(n - 1, 6 - a - b, b); // n-1개의 원반을 목표 장대로 옮긴다.

	}
}