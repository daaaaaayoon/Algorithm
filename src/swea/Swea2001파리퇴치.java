package swea;

import java.util.Scanner;

public class Swea2001파리퇴치 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc=1; tc<=TC; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] area = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					area[i][j] = sc.nextInt();
				}
			}
			
			int max=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i+(M-1)>=N || j+(M-1)>=N) continue;
					int sum=0;
					for(int c1=0; c1<M; c1++) {
						for(int c2=0; c2<M; c2++) {
							sum+=area[i+c1][j+c2];
						}
					}
					if(max <= sum) max=sum;
				}
			}
			
			System.out.println("#"+tc+" "+max);
		}//tc end
	}
}