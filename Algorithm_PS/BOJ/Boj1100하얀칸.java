package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1100ÇÏ¾áÄ­ {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] board = new char[8][8];
		
		for(int i=0; i<8; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		int ans = 0;
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(i%2 == 0 && j%2 == 0) {
					if(board[i][j]=='F') ans++;
				}
				if(i%2 == 1 && j%2 == 1) {
					if(board[i][j]=='F') ans++;
				}
			}
		}
		
		System.out.println(ans);
	}
}
