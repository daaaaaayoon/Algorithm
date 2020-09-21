package BOJ;

import java.util.Scanner;

public class Boj2578���� {

	static int N;
	static int[][] bingo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = 5;
		bingo = new int[N][N];

		// ö���� ���� ������ ���ڸ� �Է¹޴´�.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bingo[i][j] = sc.nextInt();
			}
		}

		// ��ȸ�ڰ� ���ڸ� �θ��� �����Ѵ�.
		for (int i = 1; i <= N * N; i++) {
			int num = sc.nextInt(); // ��ȸ�ڰ� �θ� ����

			// ��ȸ�ڰ� �θ� ���ڸ� ã�Ƽ� 0���� �����.
			numCheck(num);

			// ���� ��������.
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

		// ���� ������Ű�� ���� 0�� �����ν� �������� �˾ƺ���
		for (int i = 0; i < N; i++) {
			cnt = 0;
			for (int j = 0; j < N; j++) {
				if (bingo[i][j] == 0) cnt++;
				else break;
			}
			if (cnt == 5) bingoCnt++;
		}

		// ���� ������Ű�� ���� 0�� �����ν� �������� �˾ƺ���
		for (int j = 0; j < N; j++) {
			cnt = 0;
			for (int i = 0; i < N; i++) {
				if (bingo[i][j] == 0) cnt++;
				else break;
			}
			if (cnt == 5) bingoCnt++;
		}

		// �밢�� �Ʒ��ʹ������� �������� �˾ƺ���
		cnt = 0;
		for (int i = 0; i < N; i++) {
			if (bingo[i][i] == 0) cnt++;
			else break;
		}
		if (cnt == 5) bingoCnt++;

		// �밢�� ���ʹ������� �������� �˾ƺ���
		cnt = 0;
		for (int i = 0; i < N; i++) {
			if (bingo[i][4 - i] == 0) cnt++;
			else break;
		}
		if (cnt == 5) bingoCnt++;

		// ���� �ϼ�
		if (bingoCnt >= 3) return true;
		// ���� �̿ϼ�
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
