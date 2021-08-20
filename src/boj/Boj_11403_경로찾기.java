package boj;

import java.util.Scanner;

public class Boj_11403_경로찾기 {
	
	static int N, start;
	static int[][] matrix;
	static boolean[] visit;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		matrix = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<N; i++) {
			
			start = i;
			visit = new boolean[N];
			
			for(int j=0; j<N; j++) {
				if(matrix[i][j] == 1) {
					dfs(j);
				}
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void dfs(int v) {
		
		visit[v] = true;
		matrix[start][v] = 1;
		
		for(int i=0; i<N; i++) {
			if(matrix[v][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
		
	}
}
