package BOJ;

import java.math.BigInteger;
import java.util.Scanner;

public class Boj1914�ϳ���ž {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // ������ ����

		// N�� 20 �ʰ��� ��쿡�� if�� ���� ����
		BigInteger bi = new BigInteger("2"); // 2�� �ʱ�ȭ
		BigInteger c = bi.pow(N).subtract(BigInteger.ONE); // N��-1
		System.out.println(c);

		// N�� 20 ������ ���
		if(N <= 20) {
			func(N, 1, 3);
		}
	}

	static void func(int n, int a, int b) {

		if (n == 1) {
			System.out.println(a + " " + b);
			return;
		}
		func(n - 1, a, 6 - a - b); // n-1���� ������ ��ǥ��밡 �ƴ� ������ �Űܵ� ��,
		System.out.println(a + " " + b); // n��° ������ ��ǥ���� �ű��.
		func(n - 1, 6 - a - b, b); // n-1���� ������ ��ǥ ���� �ű��.

	}
}