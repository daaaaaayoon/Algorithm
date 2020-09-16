package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj7569토마토_ver1 {

	static int ans;
	static int M, N, H; // 가로(열) 세로(행) 높이
	static int[][][] box;
	static Queue<Point> queue;
	static int[] di = { 0, 0, -1, 1, 0, 0 };
	static int[] dj = { 1, -1, 0, 0, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };

	static class Point {
		int i, j, h, day;

		Point(int i, int j, int h, int day) {
			this.i = i;
			this.j = j;
			this.h = h;
			this.day = day;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();

		box = new int[N][M][H];
		queue = new LinkedList<>();

		boolean done = true;
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					box[i][j][h] = sc.nextInt();
					if (box[i][j][h] == 0)
						done = false; // 다 안익음!
					if (box[i][j][h] == 1) {
						queue.add(new Point(i, j, h, 0));
					}
				}
			}
		}
		if (done) {
			System.out.println(0);
			return;
		}

		bfs();

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (box[i][j][h] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}

		System.out.println(ans);

	}

	static void bfs() {

		while (!queue.isEmpty()) {
			Point n = queue.poll();

			for (int d = 0; d < 6; d++) {
				int ni = n.i + di[d];
				int nj = n.j + dj[d];
				int nh = n.h + dh[d];
				if (ni >= 0 && ni < N && nj >= 0 && nj < M && nh >= 0 && nh < H && box[ni][nj][nh] == 0) {
					box[ni][nj][nh] = 1;
					queue.add(new Point(ni, nj, nh, n.day + 1));
				}
			}

			ans = n.day;
		}
	}
}
