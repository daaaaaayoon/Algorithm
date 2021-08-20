package boj;

import java.util.Scanner;

public class Boj_2578_빙고 {

	static int N;
	static int[][] bingo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = 5;
		bingo = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bingo[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= N * N; i++) {
			int num = sc.nextInt();

			numCheck(num);
			if(i >= 12) {
				if (checkBingo()) {
					System.out.println(i);
					return;
				}
			}
		}
	}

	static boolean checkBingo() {
		int bingoCnt = 0, cnt = 0;

		for (int i = 0; i < N; i++) {
			cnt = 0;
			for (int j = 0; j < N; j++) {
				if (bingo[i][j] == 0) cnt++;
				else break;
			}
			if (cnt == 5) bingoCnt++;
		}

		for (int j = 0; j < N; j++) {
			cnt = 0;
			for (int i = 0; i < N; i++) {
				if (bingo[i][j] == 0) cnt++;
				else break;
			}
			if (cnt == 5) bingoCnt++;
		}

		cnt = 0;
		for (int i = 0; i < N; i++) {
			if (bingo[i][i] == 0) cnt++;
			else break;
		}
		if (cnt == 5) bingoCnt++;

		cnt = 0;
		for (int i = 0; i < N; i++) {
			if (bingo[i][4 - i] == 0) cnt++;
			else break;
		}
		if (cnt == 5) bingoCnt++;

		if (bingoCnt >= 3) return true;
		return false;
	}

	static void numCheck(int num) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (bingo[i][j] == num) {
					bingo[i][j] = 0;
					return;
				}
			}
		}
	}
}
