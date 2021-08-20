package boj;

import java.util.Scanner;

public class Boj_2563_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] paper = new int[100][100];
		
		for(int n=0; n<N; n++) {
			int x = sc.nextInt();
			int y = 99-sc.nextInt();
			
			for(int i=x; i<x+10; i++) {
				for(int j=(y-10)+1; j<=y; j++) {
					paper[i][j] = 1;
				}
			}
			
		}
		
		int ans = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(paper[i][j]==1) ans++;
			}
		}
		System.out.println(ans);
	}
}
