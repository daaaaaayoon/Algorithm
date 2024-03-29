package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11050_이항계수1_DP {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] D = new int[N+1][N+1];
		
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0 || i==j) { // nC0 = 1, nCn = 1
					D[i][j] = 1;
				}else {
					D[i][j] = D[i-1][j-1] + D[i-1][j];
				}
			}
		}
		
		System.out.println(D[N][K]);
		
	}
	
}
