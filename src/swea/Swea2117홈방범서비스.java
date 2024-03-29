package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Swea2117홈방범서비스 {

	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};

	static int N, M, ans;
	static int homeCnt, K;
	static int[][] city;
	static boolean[][] visit;
	static Queue<Point> queue;

	static class Point{
		int i, j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();

			city = new int[N][N];
			ans = Integer.MIN_VALUE;

			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					city[i][j] = sc.nextInt();
				}
			}

			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					bfs(i, j);
				}
			}

			System.out.println("#"+tc+" "+ans);

		}
	}

	static void bfs(int i, int j) {

		queue = new LinkedList<>();
		visit = new boolean[N][N];

		queue.add(new Point(i, j));
		visit[i][j] = true;

		homeCnt = 0; K = 0;

		while(!queue.isEmpty()) {

			int qSize = queue.size();

			for(int s=0; s<qSize; s++) {
				Point n = queue.poll();

				if(city[n.i][n.j] == 1) homeCnt++;

				for(int dir=0; dir<4; dir++) {
					int ni = n.i + di[dir];
					int nj = n.j + dj[dir];
					if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
					if(!visit[ni][nj]) {
						queue.add(new Point(ni, nj));
						visit[ni][nj] = true;
					}
				}
			}

			K++;

			int money = (K * K) + (K-1)*(K-1);
			if(homeCnt*M - money >= 0) {
				ans = Math.max(ans, homeCnt);
			}
		}

	}
}
