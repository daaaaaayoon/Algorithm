package BOJ;

import java.util.Scanner;

public class Boj11724연결요소의개수 {
	
	static int N, M; // 정점의 개수, 간선의 개수
	static int[] parents; // 서로소 집합을 표현하기 위한 배열 (인덱스 == 값) ? 대표자O : 대표자X
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		parents = new int[N+1]; // 1부터 N까지의 숫자만 사용할 것임
		
		// make-set연산 : 각각을 독립한 서로소 집합으로 만든다.
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		
		// 간선의 정보를 저장
		for(int i=0; i<M; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			// 입력을 받으면서 union연산을 진행한다.
			union(v1,v2);
		}
		
		// 연결요소의 개수 = 대표자의 수
		int ans = 0;
		for(int i=1; i<=N; i++) {
			if(parents[i]==i) ans++;
		}
		
		System.out.println(ans);
		
	}
	
	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) {
			parents[bRoot] = aRoot;
			return;
		}
		return;
	}
}
