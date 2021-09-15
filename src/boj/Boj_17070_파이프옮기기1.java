package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_17070_파이프옮기기1 {

	static int N, ans;
	static int[][] map;
	static int[][] didj = {{0,1}, {1,0}, {1,1}}; // 가로, 세로, 대각선

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];

		StringTokenizer st;
		for(int i=1; i<=N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(1, 2, 0);
		System.out.println(ans);

	}

	private static void dfs(int i, int j, int dir) {

		if(i == N && j == N){
			ans++;
			return;
		}
		for(int d=0; d<3; d++){

			if((dir==0 && d==1) || (dir==1 && d==0)) continue; // 가로일때 세로방향 불가, 세로일때 가로방향 불가

			int ni = i + didj[d][0];
			int nj = j + didj[d][1];
			if(ni<1 || nj<1 || ni>=N+1 || nj>=N+1 || map[ni][nj]==1) continue;
			if(d==2 && (map[ni-1][nj]==1 || map[ni][nj-1]==1)) continue; // 대각선 방향에서 빈공간인지 확인
			dfs(ni, nj, d);
		}

	}
	
}
