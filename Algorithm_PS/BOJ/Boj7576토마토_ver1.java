package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ver1 : 좌표와 함께 거리정보(일 수)저장
public class Boj7576토마토_ver1 {
	
	static int ans;
	static int M, N; // 가로 -> 열의 길이, 세로-> 행의 길이
	static int[][] box;
	static Queue<Point> queue;
	static int[] di = { 0, 0, -1, 1 };
	static int[] dj = { 1, -1, 0, 0 };

	static class Point {
		int i, j, day;

		Point(int i, int j, int day) {
			this.i = i;
			this.j = j;
			this.day = day;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();

		box = new int[N][M];
		queue = new LinkedList<>();

		boolean done = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				box[i][j] = sc.nextInt();
				if (box[i][j] == 0)
					done = false;
				if (box[i][j] == 1) {
					queue.add(new Point(i, j, 0));
				}
			}
		}

		if (done) {
			System.out.println(0);
			return;
		}

		bfs();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(ans);
	}

	static void bfs() {

		while (!queue.isEmpty()) {

			Point n = queue.poll();

			for (int d = 0; d < 4; d++) {
				int ni = n.i + di[d];
				int nj = n.j + dj[d];
				if (ni >= 0 && ni < N && nj >= 0 && nj < M && box[ni][nj] == 0) {
					box[ni][nj] = 1;
					queue.add(new Point(ni, nj, n.day+1));
				}
			}
			
			ans = n.day;
		}
	}
}
