package Boj;

import java.util.Scanner;

public class Boj_2606_바이러스 {
	
	static int N, K, ans; 
	static boolean[] visit;
	static int[][] network;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		visit = new boolean[N+1];
		network = new int[N+1][N+1];
		
		for(int k=0; k<K; k++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			network[v1][v2] = 1;
			network[v2][v1] = 1;
		}
		
		dfs(1);
		
		System.out.println(ans-1);
		
	}

	private static void dfs(int c) {
		
		visit[c] = true;
		ans++;
		
		for(int i=1; i<=N; i++) {
			if(network[c][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
		
	}
	
}
