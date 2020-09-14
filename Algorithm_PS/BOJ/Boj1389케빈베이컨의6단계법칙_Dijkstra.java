package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1389케빈베이컨의6단계법칙_Dijkstra {
	
	static int N, M;
	static boolean[][] relationship;
	static boolean[] visit;
	static int[] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		relationship = new boolean[N+1][N+1];
		
		for(int m=0; m<M; m++) {
			int u1 = sc.nextInt();
			int u2 = sc.nextInt();

			relationship[u1][u2] = true;
			relationship[u2][u1] = true;
		}
		
		int sans=Integer.MAX_VALUE, uans=Integer.MAX_VALUE;
		for(int u=1; u<=N; u++) {
			
			visit = new boolean[N+1];
			dist = new int[N+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[u] = 0; // 시작지점
			
			int min=0, cur=0;
			for(int i=1; i<=N; i++) {
				
				min = Integer.MAX_VALUE;
				
				for(int j=1; j<=N; j++) {
					if(!visit[j] && min >= dist[j]) {
						min = dist[j];
						cur = j;
					}
				}
				
				visit[cur] = true;
				
				for(int j=1; j<=N; j++) {
					if(!visit[j] && relationship[cur][j] && dist[j] >= dist[cur]+1) {
						dist[j] = dist[cur]+1;
					}
				}
				
			} // for making dist array end
			
			int sum = 0;
			for(int n=1; n<=N; n++) {
				sum+=dist[n];
			}
			if(sans > sum) {
				sans = sum;
				uans = u;
			} else if(sans == sum && uans > u) {
				uans = u;
			}
			
		}// for u end
		
		System.out.println(uans);
	}
}
