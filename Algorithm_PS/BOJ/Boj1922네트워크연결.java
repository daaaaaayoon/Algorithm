package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1922��Ʈ��ũ���� {
	
	static int N, M, ans;
	static int[] parents; // ���μ� ������ ��ǥ�ڸ� ǥ���ϱ����� �迭
	static Edge[] edgeList; // ������ ������ ������ �迭
	
	static class Edge implements Comparable<Edge>{
		int v1, v2, weight;
		Edge(int v1,int v2, int weight){
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight; // ����ġ �������� ����
		}
	}
	
	// make-set����
	static void make(){
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	// find����
	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	
	// union����
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
		
		// �ʱ�ȭ �۾�
		ans = 0;
		parents = new int[N+1];
		edgeList = new Edge[M];
		
		// ������ �������� �Է¹޴´�.
		for(int i=0; i<M; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int weight = sc.nextInt();
			edgeList[i] = new Edge(v1, v2, weight);
		}
		
		// ����ġ ������������ �������� ������ ����
		Arrays.sort(edgeList);
		
		make();
		
		int cnt = 0; // ����� ������ ������ �������� ����
		for(Edge e : edgeList) {
			if(union(e.v1, e.v2)) {
				ans += e.weight; // ����� ������ ����ġ�� ����
				// mst�� ������ ���� (������ ��-1)�� �����ϸ� Ž���� �׸��Ѵ�.
				if(++cnt == N-1) break;
			}
		}
		
		System.out.println(ans);
	}
}
