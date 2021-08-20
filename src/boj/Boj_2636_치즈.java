package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_2636_치즈 {
	
	static int N, M;
	static int[][] board;
	static Queue<Point> queue1;
	static Queue<Point> queue2;
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		board = new int[N][M];
		queue1 = new LinkedList<>();
		
		for(int i=0; i<N; i++){		
			for(int j=0; j<M; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		bfs(0, 0);
		
		int time = 0;
		int cheeseNum = 0;
		
		while(true) {
			for(int i=0; i<N; i++){
				for(int j=0; j<M; j++) {
					if(board[i][j] == -1) {
						for(int d=0; d<4; d++) {
							int ni = i + di[d];
							int nj = j + dj[d];
							if(ni<0 || ni>=N || nj<0 || nj>=M) continue;
							if(board[ni][nj] == 1) {
								board[ni][nj] = 2;
								queue1.add(new Point(ni, nj));
							}
						}
					}
				}
			} // for end
			
			if(queue1.size()!=0) cheeseNum = queue1.size();
			else break;
			
			while(!queue1.isEmpty()) {
				Point n = queue1.poll();
				bfs(n.i, n.j);
			}
			time++;
		}
		System.out.println(time);
		System.out.println(cheeseNum);
		
	}

	static void bfs(int i, int j) {
		
		queue2 = new LinkedList<>();
		queue2.add(new Point(i, j));
		board[i][j] = -1;
		
		while(!queue2.isEmpty()) {
			Point n = queue2.poll();
			board[n.i][n.j] = -1;
			
			for(int d=0; d<4; d++) {
				int ni = n.i + di[d];
				int nj = n.j + dj[d];
				if(ni<0 || ni>=N || nj<0 || nj>=M) continue;
				if(board[ni][nj] == 0) {
					queue2.add(new Point(ni, nj));
					board[ni][nj] = -1;
				}
			}
		}
	}
	
	static class Point{
		int i, j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
}
