package BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj1753최단경로_PQ {
	
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
		
		// !!!!! list 초기화 하기 !!!!!
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
			
			// 가장 작은 가중치를 가지고 있는 정점이 나옴
			int now = pq.poll().n;
			
			// 이미 확정된 정점은 지나감
			if(visit[now]) continue;
			
			// 가장 작은 거리를 가지고 나왔다! 이걸 확정시켜!
			visit[now] = true;
			
			// 지금 now에서 갈 수 있는 정점들을 탐색
			for(Edge e : list[now]) {
				// now를 거쳐서 e.n을 가는 것이 더 빠르다면
				if(dist[e.n] > dist[now] + e.weight) {
					dist[e.n] = dist[now] + e.weight; // 갱신
					pq.add(new Edge(e.n, dist[e.n])); // 추가
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
			return this.weight - o.weight; // 가중치가 작은 것이 먼저 나온다.
		}
	}
}
