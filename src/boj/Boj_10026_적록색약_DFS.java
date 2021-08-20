package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10026_적록색약_DFS {
	
	static int N, ans1, ans2; 
	static char[][] map;
	static boolean[][] visit;
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visit = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					dfs(i, j);
					ans1++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]=='R') {
					map[i][j] = 'G';
				}
			}
		}
		
		visit = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					dfs(i, j);
					ans2++;
				}
			}
		}
		
		System.out.println(ans1+" "+ans2);
	}
	
	static void dfs(int i, int j) {
		visit[i][j] = true;
		
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0 && ni<N && nj>=0 && nj<N 
					&& map[i][j] == map[ni][nj] && !visit[ni][nj]) {
				dfs(ni, nj);
			}
		}
	}
}
