package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1922_네트워크연결 {
	
	static int N, M, ans;
	static int[] parents;
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge>{
		int v1, v2, weight;
		Edge(int v1,int v2, int weight){
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
	}
	
	static void make(){
		for(int i=1; i<=N; i++) {
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		ans = 0;
		parents = new int[N+1];
		edgeList = new Edge[M];
		
		for(int i=0; i<M; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int weight = sc.nextInt();
			edgeList[i] = new Edge(v1, v2, weight);
		}
		
		Arrays.sort(edgeList);
		
		make();
		
		int cnt = 0;
		for(Edge e : edgeList) {
			if(union(e.v1, e.v2)) {
				ans += e.weight;
				if(++cnt == N-1) break;
			}
		}
		
		System.out.println(ans);
	}
}
