package BOJ;

import java.util.Scanner;

public class Boj17070파이프옮기기1 {
	
	static int N, ans;
	static int[][] house;
	static int[] di = {0, 1, 1}; // 가로, 세로, 대각선
	static int[] dj = {1, 0, 1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		house = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				house[i][j] = sc.nextInt();
			}
		}
		
		// 처음 파이프의 말단 위치를 시작점, 가로방향으로 놓아진 파이프로 시작한다.
		move(1, 2, 0);
		System.out.println(ans);
	}
	
	static void move(int i, int j, int dir) {
		
		if(i==N && j==N) {
			ans++;
			return;
		}
		
		for(int d=0; d<3; d++) {
			
			if(dir==0 && d==1) continue; // 가로로 놓여있을 때 세로방향은 불가능하다.
			if(dir==1 && d==0) continue; // 세로로 놓여있을 때 가로방향은 불가능하다.
			
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(ni>=1 && ni<=N && nj>=1 && nj<=N
					&& house[ni][nj]!=1) { // 옮기려는 곳이 비어있는가
				
				if(d==2) { // 대각선의 경우
					// 한군데 이외의 두개의 영역에도 비어있는가
					if(house[ni-1][nj]!=1 && house[ni][nj-1]!=1) {
						move(ni, nj, d);
					}
				} else {
					move(ni, nj, d);
				}
				
			}
				
		}
	}
	
}
