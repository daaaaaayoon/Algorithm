package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1916_최소비용구하기_N2 {
	
	static int N, M;
	static int A, B;
	static int[][] map;
	static boolean[] visit;
	static int[] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		dist = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			Arrays.fill(map[i], -1);
		}
		
		for(int m=0; m<M; m++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int weight = sc.nextInt();
			
			if(map[v1][v2]!=-1 && weight < map[v1][v2]) {
				map[v1][v2] = weight;
			}else if(map[v1][v2]==-1) {
				map[v1][v2] = weight;
			}
		}
		
		A = sc.nextInt();
		B = sc.nextInt();
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[A] = 0;
		
		int min=0, cur=0;
		for(int i=1; i<=N; i++) {
			
			min = Integer.MAX_VALUE;
			for(int j=1; j<=N; j++) {
				if(!visit[j] && min > dist[j]) {
					cur = j;
					min = dist[j];
				}
			}
			
			visit[cur] = true;
			
			for(int j=1; j<=N; j++) {
				if(!visit[j] && map[cur][j]!=-1 && dist[j] >= map[cur][j] + dist[cur]) {
					dist[j] = map[cur][j] + dist[cur];
				}
			}
		}
		System.out.println(dist[B]);
	}
}
