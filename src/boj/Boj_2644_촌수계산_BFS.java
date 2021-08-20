package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_2644_촌수계산_BFS {
	
	static int N, M;
	static int start, end, ans;
	static int[][] map;
	static boolean[] visit;
	static Queue<Integer> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		start = sc.nextInt();
		end = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int m=0; m<M; m++) {
			int p1 = sc.nextInt();
			int p2 = sc.nextInt();
			map[p1][p2] = 1;
			map[p2][p1] = 1;
		}
		
		bfs();
		System.out.println(ans==0?-1:ans);
	}
	
	static void bfs() {
		queue = new LinkedList<>();
		
		queue.add(start);
		visit[start] = true;
		
		int cnt=0;
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			for(int s=0; s<size; s++) {
				int n = queue.poll();
				if(n==end) {
					ans = cnt;
					return;
				}
				for(int i=1; i<=N; i++) {
					if(map[n][i]==1 && !visit[i]) {
						queue.add(i);
						visit[i] = true;
					}
				}
			}
			cnt++;
		}
	}
}
