package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1916최소비용구하기_N2 {
	
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
			
			// 두 버텍스 사이에 엣지가 최대 한개밖에 없다는 조건이 없음 => 우선순위 큐로 작성할 경우 안해도 되는 부분.
			// 들어오는 비용은 0일 수 있음
			if(map[v1][v2]!=-1 && weight < map[v1][v2]) { // 처음 들어오는 값이 아니며,지금 들어온 값이 더 작을 경우에만 갱신
				map[v1][v2] = weight;
			}else if(map[v1][v2]==-1) { // 처음 들어오는 값이면
				map[v1][v2] = weight;
			}
		}
		
		A = sc.nextInt();
		B = sc.nextInt();
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[A] = 0;
		
		int min=0, cur=0;
		for(int i=1; i<=N; i++) {
			
			// 최단 거리가 가장 작은 거리를 찾음
			min = Integer.MAX_VALUE;
			for(int j=1; j<=N; j++) {
				if(!visit[j] && min > dist[j]) { // =을 해야하나?
					cur = j;
					min = dist[j];
				}
			}
			
			visit[cur] = true;
			
			// cur에서 갈 수 있는 정점들 중에서, 이 정점을 거쳐서 가는 경우가 더 작을 경우에 갱신
			for(int j=1; j<=N; j++) {
				if(!visit[j] && map[cur][j]!=-1 && dist[j] >= map[cur][j] + dist[cur]) { // 오버플로우의 가능성은?
					dist[j] = map[cur][j] + dist[cur];
				}
			}
		}
		System.out.println(dist[B]);
	}
}
