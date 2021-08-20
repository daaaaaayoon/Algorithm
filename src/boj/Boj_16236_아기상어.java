package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_16236_아기상어 {
	
	static int N, minDist, ans;
	static int sharki, sharkj, sharkSize, eat;
	static int movei, movej;
	static int[][] space;
	static boolean[][] visit;
	static Queue<Point> queue;
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static class Point{
		int i, j, dist;
		Point(int i, int j, int dist){
			this.i = i;
			this.j = j;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		space = new int[N][N];
		visit = new boolean[N][N];
		queue = new LinkedList<>();
		minDist = Integer.MAX_VALUE;
		eat = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				space[i][j] = sc.nextInt();
				if(space[i][j] == 9) {
					sharki = i;
					sharkj = j;
					sharkSize = 2;
					space[i][j] = 0;
					queue.add(new Point(sharki, sharkj, 0));
					visit[i][j] = true;
				}
			}
		}
		
		while(true) {
			
			bfs();
			
			if(minDist == Integer.MAX_VALUE) break;
			
			ans += minDist;
			if(++eat == sharkSize) {
				sharkSize++;
				eat = 0;
			}
			
			space[movei][movej] = 0;

			queue = new LinkedList<>();
			queue.add(new Point(movei, movej, 0));
			visit = new boolean[N][N];
			visit[movei][movej] = true;
			minDist = Integer.MAX_VALUE;
			movei = -1; movej = N;
		}
		
		System.out.println(ans);
		
	}
	
	static void bfs() {
		
		while(!queue.isEmpty()) {
			
			Point n = queue.poll();
			
			if(space[n.i][n.j]!=0 && space[n.i][n.j] < sharkSize) {
				if(n.dist == minDist && n.i <= movei) {
					if(n.i == movei && n.j < movej) {
						movei = n.i;
						movej = n.j;
					}else if(n.i < movei) {
						movei = n.i;
						movej = n.j;
					}
				}else if(n.dist < minDist) {
					movei = n.i;
					movej = n.j;
					minDist = n.dist;
				}
			}
			
			for(int d=0; d<4; d++) {
				int ni = n.i + di[d];
				int nj = n.j + dj[d];
				if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
				if(space[ni][nj]<=sharkSize && !visit[ni][nj]) {
					queue.add(new Point(ni, nj, n.dist+1));
					visit[ni][nj] = true;
				}
			}
		}
	}// bfs end
	
}
