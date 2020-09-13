package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1647���ú��Ұ�ȹ {
	// �и��������� ���� ���� �������� ���� ���� �ּҰ� �ǵ��� mst�� ���� ��,
	// ���� �������� ���� �ּҷ� �ϸ鼭, ������ �и��ϱ� ���� ���� ū ����ġ�� ���� ������ �����ϸ� �ȴ�.
	
	static int N, M, ans; // ���� ����, ���� ����
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
			return this.weight - o.weight; // ����ġ �������� ����
		}
	}
	
	// ���μ� ���� �����
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
		
		// ũ�罺Į �˰����� �̿��� mst�� �����
		Arrays.sort(edgeList); // ���� ������������ ����
		
		make();
		
		int cnt=0, max=0;
		for(Edge e : edgeList) {
			if(union(e.v1, e.v2)) {
				if(e.weight > max) {
					max = e.weight; // mst�� ���ԵǴ� ���� �� ���� ū ���� �����.
				}
				ans += e.weight;
				cnt++;
				if(cnt == N-1) break; // mst�� ��������� ������.
			}
		}
		
		System.out.println(ans-max);
	}
}
