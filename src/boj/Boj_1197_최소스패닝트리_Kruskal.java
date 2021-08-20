package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1197_최소스패닝트리_Kruskal {
	
	static int V, E;
	static int[] parents;
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		Edge(int from, int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int[V+1];
		edgeList = new Edge[E];

		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edgeList[i] = new Edge(from, to, weight);
		}

		Arrays.sort(edgeList);
		
		make();
		
		int ans = 0, cnt = 0;
		for(Edge e : edgeList) {
			if(union(e.from, e.to)) {
				ans += e.weight;
				cnt++;
				if(cnt == V-1) break;
			}
		}

		System.out.println(ans);
	}
	
	static void make() {
		for(int i=1; i<=V; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) {
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}
	
	
}
