package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1753_최단경로_V2 {
	
	static int V, E, start;
	static int[] dist;
	static int[][] arr;
	static boolean[] visit;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		start = sc.nextInt();
		
		dist = new int[V+1];
		visit = new boolean[V+1];
		arr = new int[V+1][V+1];
		
		for(int i=0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			
			if(arr[from][to]!=0 && arr[from][to]>weight) {
				arr[from][to] = weight;
			}else if(arr[from][to]==0) {
				arr[from][to] = weight;
			}
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start]=0;
		
		int min = 0, cur = 0;
		for(int i=1; i<=V; i++) {
			
			min = Integer.MAX_VALUE;
			for(int j=1; j<=V; j++) {
				if(min > dist[j] && !visit[j]) {
					min = dist[j];
					cur = j;
				}
			}
			
			visit[cur] = true;
			
			for(int j=1; j<=V; j++) {
				if(arr[cur][j]!=0 && dist[j] > dist[cur]+arr[cur][j]) {
					dist[j] = dist[cur]+arr[cur][j];
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			System.out.println(dist[i]==Integer.MAX_VALUE?"INF":dist[i]);
		}
	}
	
}
