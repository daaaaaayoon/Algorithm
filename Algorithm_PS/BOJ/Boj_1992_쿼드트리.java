package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1992_쿼드트리 {
	
	static int N;
	static int[][] video;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		video = new int[N][N];
		
		int[] count = new int[2];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			char[] chArr = line.toCharArray();
			for(int j=0; j<N; j++) {
				video[i][j] = chArr[j] - '0';
				count[video[i][j]]++;
			}
		}
		
		// 시작부터 모두 0이거나 1인 경우
		if(count[0] == N*N) {
			System.out.println("0");
			return;
		}else if(count[1] == N*N) {
			System.out.println("1");
			return;
		}
		
		solve(0, 0, N, 1);
		
		System.out.println(sb.toString());
		
	}

	private static void solve(int si, int sj, int len, int order) {
		
		int[] count = new int[2];
		for(int i=si; i<si+len; i++) {
			for(int j=sj; j<sj+len; j++) {
				count[video[i][j]]++;
			}
		}
		
		
		if(count[0] == len*len) {
			sb.append('0');
			return;
		}else if(count[1] == len*len) {
			sb.append('1');
			return;
		}
		
		sb.append('(');
		solve(si, sj, len/2, 1);
		solve(si, sj+len/2, len/2, 2);
		solve(si+len/2, sj, len/2, 3);
		solve(si+len/2, sj+len/2, len/2, 4);
		sb.append(')');
		
	}
	
}
