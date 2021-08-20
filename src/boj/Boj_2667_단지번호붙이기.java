package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Boj_2667_단지번호붙이기 {
	
	static int N, area;
	static int[][] map;
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				char c = line.charAt(j);
				map[i][j] = c - 48;
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1) {
					area = 0;
					dfs(i, j);
					ans.add(area);
				}
			}
		}
		
		System.out.println(ans.size());
		Collections.sort(ans);
		for(int a : ans) {
			System.out.println(a);
		}
	}
	
	static void dfs(int i, int j) {
		area++;
		map[i][j] = 9;
		
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0 && ni<N && nj>=0 && nj<N && map[ni][nj]==1) {
				dfs(ni, nj);
			}
		}
	}
	
}
