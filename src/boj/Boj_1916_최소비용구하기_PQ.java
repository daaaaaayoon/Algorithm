package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj_1916_최소비용구하기_PQ {

	static int N, M;
	static ArrayList<Edge>[] list;
	static PriorityQueue<Edge> pq;
	static boolean[] visit;
	static int[] dist;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		visit = new boolean[N+1];
		dist = new int[N+1];
		list = new ArrayList[N+1]; // 1���� N����
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int m=0; m<M; m++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int w = sc.nextInt();
			
			list[from].add(new Edge(to, w));
		}
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start]= 0;
		
		pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			
			int now = pq.poll().num;
			
			if(visit[now]) continue;
			visit[now] = true;
			
			for(int i=0; i<list[now].size(); i++) {
				
				Edge e = list[now].get(i);
				
				if(dist[e.num] > dist[now] + e.weight) {
					dist[e.num] = dist[now] + e.weight;
					pq.add(new Edge(e.num, dist[e.num]));
				}
			}
		}
		
		System.out.println(dist[end]);
		
	}
	
	static class Edge implements Comparable<Edge>{
		int num, weight;
		Edge(int num, int weight){
			this.num = num;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}
