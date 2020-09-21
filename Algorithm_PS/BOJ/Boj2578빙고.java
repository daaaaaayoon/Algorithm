package BOJ;

import java.util.Scanner;

public class Boj2578빙고 {

	static int N;
	static int[][] bingo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = 5;
		bingo = new int[N][N];

		// 철수가 적은 빙고의 숫자를 입력받는다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bingo[i][j] = sc.nextInt();
			}
		}

		// 사회자가 숫자를 부르기 시작한다.
		for (int i = 1; i <= N * N; i++) {
			int num = sc.nextInt(); // 사회자가 부른 숫자

			// 사회자가 부른 숫자를 찾아서 0으로 만든다.
			numCheck(num);

			// 빙고를 세러간다.
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

		// 행은 고정시키고 열의 0을 셈으로써 빙고인지 알아보기
		for (int i = 0; i < N; i++) {
			cnt = 0;
			for (int j = 0; j < N; j++) {
				if (bingo[i][j] == 0) cnt++;
				else break;
			}
			if (cnt == 5) bingoCnt++;
		}

		// 열은 고정시키고 행의 0을 셈으로써 빙고인지 알아보기
		for (int j = 0; j < N; j++) {
			cnt = 0;
			for (int i = 0; i < N; i++) {
				if (bingo[i][j] == 0) cnt++;
				else break;
			}
			if (cnt == 5) bingoCnt++;
		}

		// 대각선 아래쪽방향으로 빙고인지 알아보기
		cnt = 0;
		for (int i = 0; i < N; i++) {
			if (bingo[i][i] == 0) cnt++;
			else break;
		}
		if (cnt == 5) bingoCnt++;

		// 대각선 위쪽방향으로 빙고인지 알아보기
		cnt = 0;
		for (int i = 0; i < N; i++) {
			if (bingo[i][4 - i] == 0) cnt++;
			else break;
		}
		if (cnt == 5) bingoCnt++;

		// 빙고 완성
		if (bingoCnt >= 3) return true;
		// 빙고 미완성
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
