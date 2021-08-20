package boj;

import java.util.Scanner;

public class Boj_1389_케빈베이컨의6단계법칙_DFS {

	static int kbnum, kans, uans; // �ɺ� ������ ���� �� ����, �� : �ɺ����� ��, ������ ��ȣ
	static int N, M;
	static int[][] map;
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int m=0; m<M; m++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			map[v1][v2] = 1;
			map[v2][v1] = 1;
		}
		
		// ������ �ϳ��� �����ؼ� ���� �ɺ� ������ ���� ���Ѵ�.
		kans = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++) {
			kbnum = 0;
			dfs(i, 0); // ������ ��ȣ, �ɺ� ������ ��
			
			// �� �� ���� ������ ���� �߿� �ּҰ��� ���ϰ�, ���� ������ ���� ���ٸ� ������ ���� ���� �����ַ� �������ش�.
			if(kans > kbnum) {
				uans = i;
				kans = kbnum;
			}else if(kans == kbnum && uans > i) {
				uans = i;
			}
		}
		
		System.out.println(uans);
		
	}
	
	static void dfs(int v, int kbn) {
		visit[v] = true;
		
		kbnum += kbn;
		
		for(int i=1; i<=N; i++) {
			if(map[v][i]==1 && !visit[i]) {
				dfs(i, kbn+1);
			}
		}
		
		visit[v] = false; // �ٸ� ����(����)�� dfsŽ���� ���� �����ϵ���!
	}
	
	
}
