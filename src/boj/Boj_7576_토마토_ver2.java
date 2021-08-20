package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_7576_토마토_ver2 {
	
	static int day;
	static int M, N;
	static int[][] box;
	static Queue<Point> queue;
	static int[] di = {0,0,-1,1};
	static int[] dj = {1,-1,0,0};
	
	static class Point{
		int i, j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		box = new int[N][M];
		queue = new LinkedList<>();
		
		boolean done = true;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				box[i][j] = sc.nextInt();
				if(box[i][j]==0) done = false;
				if(box[i][j]==1) {
					queue.add(new Point(i, j));
				}
			}
		}
		
		if(done) {
			System.out.println(0);
			return;
		}
		
		bfs();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j]==0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(day-1);
	}
	
	static void bfs() {
		
		while(!queue.isEmpty()) {
			int qSize = queue.size();
			
			for(int s=0; s<qSize; s++) {
				Point n = queue.poll();
				
				for(int d=0; d<4; d++){
					int ni = n.i + di[d];
					int nj = n.j + dj[d];
					if(ni>=0 && ni<N && nj>=0 && nj<M 
							&& box[ni][nj]==0) {
						box[ni][nj] = 1;
						queue.add(new Point(ni, nj));
					}
				}
			}
			
			day++;
		}
	}
}
