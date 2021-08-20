package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Swea1238Contact_DFS {
	
	static int N, K, ans, maxDist;
	static int[][] contact;
	static int[] dist;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = 10;
		for(int tc=1; tc<=TC; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			contact = new int[101][101];
			dist = new int[101]; // �� ������ �湮�ϰ� �� �Ÿ��� ����ϴ� �迭
			
			for(int n=0; n<N/2; n++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				contact[from][to] = 1;
			}
			
			Arrays.fill(dist, Integer.MAX_VALUE);
			dfs(K, 0);

			maxDist = Integer.MIN_VALUE;
			for(int i=0; i<=100; i++) { // i�� ������ => �Ÿ��� �� �ֵ� �߿� ���ڰ� ���� ū ��
				if(dist[i]!=Integer.MAX_VALUE && dist[i]>=maxDist) {
					maxDist = dist[i];
					ans = i;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	// �ش� ���������� �Ÿ��� ����ϰ�, �� ª�� �Ÿ��� �湮�� �����Ҷ��� ��湮�Ѵ�.
	static void dfs(int v, int cnt) {
		
		dist[v] = cnt;
		
		for(int i=0; i<=100; i++) {
			if(contact[v][i]==1 && dist[i]>cnt+1) {
				dfs(i, cnt+1);
			}
		}
	}
}