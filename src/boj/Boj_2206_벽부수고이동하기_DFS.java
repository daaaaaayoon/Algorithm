package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2206_벽부수고이동하기_DFS {
	static char[][] map;
	static int N, M;
	static int[][][] visit;
	static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visit = new int[2][N][M];
		for(int i = 0; i < N; i++) 
			map[i] = br.readLine().toCharArray();
		
		dfs(0,0,0,0);
		
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);	
	}
	
	static void dfs(int r, int c, int cnt, int broken) {
		
		if(r == N-1 && c == M-1) {
			min = Math.min(min, cnt+1);
			return ;
		}
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			if(map[nr][nc] == '1' && broken == 0) {
				if(visit[0][nr][nc] == 0 || visit[0][nr][nc] > cnt+1) {
					visit[0][nr][nc] = cnt+1;
					dfs(nr, nc, cnt+1, 1);
				}
			}else if(map[nr][nc] == '0') {
				if(visit[broken][nr][nc] == 0 || visit[broken][nr][nc] > cnt+1) {
					visit[broken][nr][nc] = cnt+1;
					dfs(nr, nc, cnt+1, broken);
				}
			}
		}
	}
}