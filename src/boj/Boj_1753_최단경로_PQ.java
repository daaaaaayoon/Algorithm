package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj_1753_최단경로_PQ {
	
	static int V, E, start;
	static ArrayList<Edge>[] list;
	static int[] dist;
	static boolean[] visit;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		start = sc.nextInt();
		
		dist = new int[V+1];
		visit = new boolean[V+1];

		list = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			
			list[from].add(new Edge(to, weight));
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start]=0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			
			int now = pq.poll().n;
			
			if(visit[now]) continue;
			
			visit[now] = true;
			
			for(Edge e : list[now]) {
				if(dist[e.n] > dist[now] + e.weight) {
					dist[e.n] = dist[now] + e.weight;
					pq.add(new Edge(e.n, dist[e.n]));
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			System.out.println(dist[i]==Integer.MAX_VALUE?"INF":dist[i]);
		}
	}
	
	static class Edge implements Comparable<Edge>{
		
		int n;
		int weight;
		Edge(int n, int weight){
			this.n = n;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight; // ����ġ�� ���� ���� ���� ���´�.
		}
	}
}
