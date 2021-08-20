package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boj_2583_영역구하기 {
	
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	static int N, M, K, size;
	static int[][] area;
	static ArrayList<Integer> ans;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); 
		N = sc.nextInt(); 
		K = sc.nextInt();
		area = new int[N][M];
		
		for(int k=0; k<K; k++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for(int x=x1; x<x2; x++) {
				for(int y=y1; y<y2; y++) {
					area[x][y]=1;
				}
			}
		}
		// DFS
		ans = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(area[i][j]==0) {
					size=0;
					dfs(i, j);
					ans.add(size);
				}
			}
		}
		
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int a: ans) {
			System.out.print(a+" ");
		}
	}
	
	static void dfs(int i, int j) {
		area[i][j] = 9;
		size++;
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0 && nj>=0 && ni<N && nj<M && area[ni][nj]==0) {
				dfs(ni, nj);
			}
		}
	}
}