package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1197최소스패닝트리_Kruskal {
	
	static int V, E; // 정점의 수, 간선의 수
	static int[] parents; // 서로소 집합을 표현하기위한 배열
	static Edge[] edgeList; // 간선의 정보를 저장할 간선리스트
	
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
		
		// 간선의 종류를 입력받는다.
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// 간선리스트에 저장
			edgeList[i] = new Edge(from, to, weight);
		}
		
		// 가중치 오름차순으로 정렬
		Arrays.sort(edgeList);
		
		make(); // 서로소집합을 만든다
		
		int ans = 0, cnt = 0;
		for(Edge e : edgeList) {
			if(union(e.from, e.to)) { // true이면 합치기 가능.
				ans += e.weight;
				cnt++;
				if(cnt == V-1) break; // 최소신장트리가 모두 만들어지면 나간다.
			}
		}
		
		// 최소 신장 트리의 가중치 출력
		System.out.println(ans);
	}
	
	static void make() {
		for(int i=1; i<=V; i++) {
			parents[i] = i; // 각자가 대표자가 된다.
		}
	}
	
	static int find(int a) {
		if(parents[a]==a) return a; // a가 대표자이라면, a를 반환
		return parents[a] = find(parents[a]); // 경로압축을 진행하며 대표자를 찾는다.
	}
	
	static boolean union(int a, int b) {
		
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) { // 서로의 대표자가 다르다면, union연산을 진행 가능하다.
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}
	
	
}
