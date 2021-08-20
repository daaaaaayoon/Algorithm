package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1987_알파벳 {
	static int R, C, ans;
	static char[][] board;
	static boolean[] alphabet;
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		alphabet = new boolean[26];
		
		for(int i=0; i<R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		dfs(0,0,1);
		System.out.println(ans);
	}
	
	static void dfs(int i, int j, int cnt) {
		alphabet[board[i][j]-65] = true; // 'A' - 65 = 0
		
		if(cnt > ans) ans = cnt;
		
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0 && ni<R && nj>=0 && nj<C && !alphabet[board[ni][nj]-65]) {
				dfs(ni, nj, cnt+1);
			}
		}
		
		alphabet[board[i][j]-65] = false;
	}
}
