package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1210Ladder_Other {
	
	static int nowi, nowj, ans;
	static int[][] ladder;
	
	static int[] di = {0,0,-1}; // 좌 우 상
	static int[] dj = {-1,1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int TC = 10; // 테스트케이스의 개수
		for(int tc=1; tc<=TC; tc++) {
			
			int t = Integer.parseInt(br.readLine()); // 테스트케이스 입력
			
			ladder = new int[100][100];
			
			// ladder 배열 입력받기
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if(ladder[i][j]==2) { // 시작 위치 저장
						nowi = i; nowj = j;
					}
				}
			}
			
			while(true) {
				if(nowi == 0) {
					ans = nowj;
					break;
				}
					
				for(int d=0; d<3; d++) {
					int nexti = nowi + di[d];
					int nextj = nowj + dj[d];
					if(0<=nexti && nexti<100 && 0<=nextj && nextj<100 && ladder[nexti][nextj] == 1) {
						ladder[nexti][nextj] = 9;
						nowi = nexti;
						nowj = nextj;
						break;
					}
				}
			}
			
			System.out.println("#"+t+" "+ans);
		}
	}
}
