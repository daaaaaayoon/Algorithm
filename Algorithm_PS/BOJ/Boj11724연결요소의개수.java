package BOJ;

import java.util.Scanner;

public class Boj11724�������ǰ��� {
	
	static int N, M; // ������ ����, ������ ����
	static int[] parents; // ���μ� ������ ǥ���ϱ� ���� �迭 (�ε��� == ��) ? ��ǥ��O : ��ǥ��X
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		parents = new int[N+1]; // 1���� N������ ���ڸ� ����� ����
		
		// make-set���� : ������ ������ ���μ� �������� �����.
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		
		// ������ ������ ����
		for(int i=0; i<M; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			// �Է��� �����鼭 union������ �����Ѵ�.
			union(v1,v2);
		}
		
		// �������� ���� = ��ǥ���� ��
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
