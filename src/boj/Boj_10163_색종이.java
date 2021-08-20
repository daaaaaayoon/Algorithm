package boj;

import java.util.Scanner;

public class Boj_10163_색종이 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] paper = new int[101][101];
		
		for(int n=1; n<=N; n++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();
			
			for(int i=x; i<(x+width); i++) {
				for(int j=y; j<(y+height); j++) {
					paper[i][j] = n;
				}
			}
		}
		
		for(int n=1; n<=N; n++) {
			
			int cnt = 0;
			for(int i=0; i<=100; i++) {
				for(int j=0; j<=100; j++) {
					if(paper[i][j]==n) cnt++;
				}
			}
			System.out.println(cnt);
			
		}
	}
}
