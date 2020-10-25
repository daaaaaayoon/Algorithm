package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2178¹Ì·ÎÅ½»ö {
	public static void main(String[] args) {
		
		int[] dr = {0,0,-1,1};
		int[] dc = {-1,1,0,0};
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] maze = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String line = sc.next();
			for(int j=0; j<M; j++) {
				char ch = line.charAt(j);
				maze[i][j] = ch - 48;
			}
		}
		
		Queue<Point> q = new LinkedList<>();
		
		q.add(new Point(0,0,1));
		maze[0][0] = 9;
		
		while(!q.isEmpty()) {
			Point n = q.poll();
			
			if(n.r == N-1 && n.c == M-1) {
				System.out.println(n.dist);
				break;
			}
			
			for(int d=0; d<4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				if(0<=nr && nr<N && 0<=nc && nc<M && maze[nr][nc]==1) {
					q.add(new Point(nr, nc, n.dist+1));
					maze[nr][nc] = 9;
				}
			}
		}
		
	}
	
	static class Point{
		int r, c, dist;
		Point(int r, int c, int dist){
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
}
