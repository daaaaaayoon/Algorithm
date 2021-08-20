package boj;

import java.util.Scanner;

public class Boj_2644_촌수계산_DFS {
	static int N, M;
	static int start, end, ans;
	static int[][] map;
	static boolean[] visit;
	
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
		
		dfs(start, 0);
		System.out.println(ans==0?-1:ans);
	}
	
	static void dfs(int n, int cnt) {
		
		if(n == end) { 
			ans = cnt; 
			return; 
		}
		
		visit[n] = true;
		
		for(int i=1; i<=N; i++) {
			if(map[n][i]==1 && !visit[i]) {
				dfs(i, cnt+1);
			}
		}
	}
}
