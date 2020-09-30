package SWEA;

import java.util.Scanner;

public class Swea4301콩많이심기 {
	
	static int N, M, ans; // 행 열
	static int[][] area;
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			M = sc.nextInt(); // 열
			N = sc.nextInt(); // 행
			
			area = new int[N][M]; // 밭
			
			bean();
			
			ans = 0;
			// 심어진 콩의 개수를 센다
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(area[i][j]==1) ans++;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void bean() {
		
		// 밭에 콩을 놓을 수 있는지를 보자.
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				boolean beanExist = false;
				// 사방으로 거리 2만큼 콩이 있는지 보자.
				for(int dir=0; dir<4; dir++) {
					int nexti = i + di[dir]*2; 
					int nextj = j + dj[dir]*2; 
					if(nexti<0 || nexti>=N || nextj<0 || nextj>=M) continue;
					// 콩이 있다면
					if(area[nexti][nextj]==1) { 
						beanExist = true; // 콩이 있다고 표시
						break;
					}
				}
				// 콩을 놓을 수 있다면 (사방 거리 2만큼 콩이 없다면)
				if(!beanExist) {
					area[i][j] = 1; // 콩을 놓자
				}
			}
		}
	}
}
