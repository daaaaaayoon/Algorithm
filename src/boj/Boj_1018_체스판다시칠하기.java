package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1018_체스판다시칠하기 {
	
	static char[][] board1 = {{'W','B','W','B','W','B','W','B'},
							  {'B','W','B','W','B','W','B','W'},
							  {'W','B','W','B','W','B','W','B'},
							  {'B','W','B','W','B','W','B','W'},
							  {'W','B','W','B','W','B','W','B'},
							  {'B','W','B','W','B','W','B','W'},
							  {'W','B','W','B','W','B','W','B'},
							  {'B','W','B','W','B','W','B','W'}};
	
	static char[][] board2 = {{'B','W','B','W','B','W','B','W'},
							  {'W','B','W','B','W','B','W','B'},
							  {'B','W','B','W','B','W','B','W'},
							  {'W','B','W','B','W','B','W','B'},
							  {'B','W','B','W','B','W','B','W'},
							  {'W','B','W','B','W','B','W','B'},
							  {'B','W','B','W','B','W','B','W'},
							  {'W','B','W','B','W','B','W','B'}};
	
	static int N, M, ans;
	static char[][] board;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		board = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			board[i] = line.toCharArray();
		}
		
		
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				compare(i, j);
			}
		}
		
		System.out.println(ans);
		
	}
	
	static void compare(int i, int j) {
		
		int cnt1 = 0;
		int cnt2 = 0;
		for(int k=0; k<8; k++) {
			for(int z=0; z<8; z++) {
				if(board[i+k][j+z] != board1[k][z]) cnt1++;
				if(board[i+k][j+z] != board2[k][z]) cnt2++;
			}
		}
		ans = Math.min(ans, cnt1);
		ans = Math.min(ans, cnt2);
		
	}
	
}
