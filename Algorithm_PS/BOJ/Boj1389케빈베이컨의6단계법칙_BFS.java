package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1389케빈베이컨의6단계법칙_BFS {

	static int kans, uans; // 답 : 케빈베이컨 수, 유저의 번호
	static int N, M;
	static int[][] map;
	static boolean[] visit;
	static Queue<Integer> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N + 1][N + 1];
		queue = new LinkedList<>();

		for (int m = 0; m < M; m++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			map[v1][v2] = 1;
			map[v2][v1] = 1;
		}

		kans = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			// 모든 정점으로부터 bfs탐색을 진행
			visit = new boolean[N + 1];
			int kbnum = bfs(i);
			if (kbnum < kans) {
				uans = i;
				kans = kbnum;
			} else if (kbnum == kans && uans > i) {
				uans = i;
			}
		}

		System.out.println(uans);

	}

	static int bfs(int v) {

		for (int i = 1; i <= N; i++) {
			if (map[v][i] == 1) {
				queue.add(i);
				visit[i] = true;
			}
		}

		int kbn = 0, cnt = 0;
		while (!queue.isEmpty()) {

			int qSize = queue.size();

			cnt++; // 출발지로부터의 거리

			for (int s = 0; s < qSize; s++) {
				
				int n = queue.poll();
				
				kbn += cnt; // 출발지로부터의 거리를 누적
				
				for (int j = 1; j <= N; j++) {
					if (map[n][j] == 1 && !visit[j]) {
						queue.add(j);
						visit[j] = true;
					}
				}
			}
		}

		return kbn;
	}
}
