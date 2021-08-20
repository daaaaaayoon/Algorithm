package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea7699수지의수지맞는여행 {
	static int R, C, ans;
	static char[][] map;
	static boolean[] alphabet;
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new char[R][];
			alphabet = new boolean[26]; 
			
			for(int i=0; i<R; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			ans = 0;
			dfs(0,0,1);
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void dfs(int i, int j, int dist) {
		
		ans = Math.max(ans, dist);
		
		alphabet[map[i][j]-'A'] = true;
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0 && nj>=0 && ni<R && nj<C && !alphabet[map[ni][nj]-'A']) {
				dfs(ni, nj, dist+1);
			}
		}
		alphabet[map[i][j]-'A'] = false;
	}
}
