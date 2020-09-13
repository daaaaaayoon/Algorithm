package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1647도시분할계획 {
	// 분리되지않은 마을 길의 유지비의 합이 가장 최소가 되도록 mst를 만든 후,
	// 길의 유지비의 합을 최소로 하면서, 마을을 분리하기 위해 가장 큰 가중치를 가진 간선을 제거하면 된다.
	
	static int N, M, ans; // 집의 개수, 길의 개수
	static int[] parents; 
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge>{
		int v1, v2, weight;
		Edge(int v1, int v2, int weight){
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight; // 가중치 오름차순 정렬
		}
	}
	
	// 서로소 집합 연산들
	static void make() {
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
		
		parents = new int[N+1]; 
		edgeList = new Edge[M];
		
		for(int m=0; m<M; m++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int weight = sc.nextInt();
			
			edgeList[m] = new Edge(v1, v2, weight);
		}
		
		// 크루스칼 알고리즘을 이용해 mst를 만든다
		Arrays.sort(edgeList); // 간선 오름차순으로 정렬
		
		make();
		
		int cnt=0, max=0;
		for(Edge e : edgeList) {
			if(union(e.v1, e.v2)) {
				if(e.weight > max) {
					max = e.weight; // mst에 포함되는 간선 중 가장 큰 값이 저장됨.
				}
				ans += e.weight;
				cnt++;
				if(cnt == N-1) break; // mst가 만들어지면 나간다.
			}
		}
		
		System.out.println(ans-max);
	}
}
