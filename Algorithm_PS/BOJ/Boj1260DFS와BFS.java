package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1260DFS와BFS {
	static int N, M, V;
	static int[][] map;
	static boolean[] visit;
	static Queue<Integer> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점의 개수
		M = sc.nextInt(); // 간선의 개수
		V = sc.nextInt(); // 시작 정점

		map = new int[N + 1][N + 1];
		visit = new boolean[N + 1];

		for (int m = 0; m < M; m++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			map[from][to] = 1;
			map[to][from] = 1;
		}

		dfs(V);
		
		System.out.println();
		
		bfs();

	}

	static void dfs(int v) {
		System.out.print(v+" ");
		visit[v] = true;
		for (int i = 1; i <= N; i++) {
			if (!visit[i] && map[v][i] == 1) {
				dfs(i);
			}
		}
	}

	static void bfs() {
		
		visit = new boolean[N + 1];
		queue = new LinkedList<>();
		queue.add(V);
		visit[V] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			System.out.print(n+" ");
			for (int i = 1; i <= N; i++) {
				if (!visit[i] && map[n][i] == 1) {
					visit[i] = true;
					queue.add(i);
				}
			}
		}
		
	}
}
