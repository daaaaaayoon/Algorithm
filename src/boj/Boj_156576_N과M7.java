package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_156576_N과M7 {

	static int N, M;
	static int[] input, ans;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		input = new int[N];
		ans = new int[M];
		sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		Arrays.sort(input);

		perm(0);

		System.out.println(sb.toString());
	}

	static void perm(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			ans[cnt] = input[i];
			perm(cnt + 1);
		}
	}
}
