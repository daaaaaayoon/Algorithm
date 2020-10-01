package BOJ;

import java.util.Scanner;

public class Boj2961도영이가만든맛있는음식 {
	
	static int N, ans, count;
	static int[][] tasty; // 0열은 신맛 1열은 쓴맛
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		tasty = new int[N][2];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				tasty[i][j] = sc.nextInt();
			}
		}

		ans = Integer.MAX_VALUE;
		subset(0);
		System.out.println(ans);
	}

	static void subset(int cnt) {
		if (cnt == N) {

			// select가 true인 재료들로 음식을 만듬
			int sour = 1, bitter = 0;
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				// 음식을 사용
				if (isSelected[i]) {
					flag = true;
					sour *= tasty[i][0];
					bitter += tasty[i][1];
				}
			}
			
			if(flag) ans = Math.min(ans, Math.abs(sour - bitter));
			return;

		} else {
			isSelected[cnt] = true;
			subset(cnt + 1);
			isSelected[cnt] = false;
			subset(cnt + 1);
		}
	}

}
