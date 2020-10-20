package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1916�ּҺ�뱸�ϱ�_N2 {
	
	static int N, M;
	static int A, B;
	static int[][] map;
	static boolean[] visit;
	static int[] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		dist = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			Arrays.fill(map[i], -1);
		}
		
		for(int m=0; m<M; m++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int weight = sc.nextInt();
			
			// �� ���ؽ� ���̿� ������ �ִ� �Ѱ��ۿ� ���ٴ� ������ ���� => �켱���� ť�� �ۼ��� ��� ���ص� �Ǵ� �κ�.
			// ������ ����� 0�� �� ����
			if(map[v1][v2]!=-1 && weight < map[v1][v2]) { // ó�� ������ ���� �ƴϸ�,���� ���� ���� �� ���� ��쿡�� ����
				map[v1][v2] = weight;
			}else if(map[v1][v2]==-1) { // ó�� ������ ���̸�
				map[v1][v2] = weight;
			}
		}
		
		A = sc.nextInt();
		B = sc.nextInt();
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[A] = 0;
		
		int min=0, cur=0;
		for(int i=1; i<=N; i++) {
			
			// �ִ� �Ÿ��� ���� ���� �Ÿ��� ã��
			min = Integer.MAX_VALUE;
			for(int j=1; j<=N; j++) {
				if(!visit[j] && min > dist[j]) { // =�� �ؾ��ϳ�?
					cur = j;
					min = dist[j];
				}
			}
			
			visit[cur] = true;
			
			// cur���� �� �� �ִ� ������ �߿���, �� ������ ���ļ� ���� ��찡 �� ���� ��쿡 ����
			for(int j=1; j<=N; j++) {
				if(!visit[j] && map[cur][j]!=-1 && dist[j] >= map[cur][j] + dist[cur]) { // �����÷ο��� ���ɼ���?
					dist[j] = map[cur][j] + dist[cur];
				}
			}
		}
		System.out.println(dist[B]);
	}
}
