package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1922네트워크연결 {
	
	static int N, M, ans;
	static int[] parents; // 서로소 집합의 대표자를 표현하기위한 배열
	static Edge[] edgeList; // 간선의 정보를 저장할 배열
	
	static class Edge implements Comparable<Edge>{
		int v1, v2, weight;
		Edge(int v1,int v2, int weight){
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight; // 가중치 오름차순 정렬
		}
	}
	
	// make-set연산
	static void make(){
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	// find연산
	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	
	// union연산
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
		
		// 초기화 작업
		ans = 0;
		parents = new int[N+1];
		edgeList = new Edge[M];
		
		// 간선의 정보들을 입력받는다.
		for(int i=0; i<M; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int weight = sc.nextInt();
			edgeList[i] = new Edge(v1, v2, weight);
		}
		
		// 가중치 오름차순으로 간선들의 정보를 정렬
		Arrays.sort(edgeList);
		
		make();
		
		int cnt = 0; // 연결된 간선의 개수를 세기위한 변수
		for(Edge e : edgeList) {
			if(union(e.v1, e.v2)) {
				ans += e.weight; // 연결된 간선의 가중치를 저장
				// mst의 간선의 수인 (정점의 수-1)을 만족하면 탐색을 그만한다.
				if(++cnt == N-1) break;
			}
		}
		
		System.out.println(ans);
	}
}
