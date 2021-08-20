package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_4963_섬의개수_BFS {
	
	static int W, H, ans;
	static int[][] map;
	static boolean[][] visit;
	static Queue<Point> queue;
	static int[] di = {0,0,-1,1,-1,1,1,-1};
	static int[] dj = {-1,1,0,0,-1,1,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			W = sc.nextInt();
			H = sc.nextInt();
			
			if(W == 0 && H == 0) break;
			
			map = new int[H][W];
			visit = new boolean[H][W];
			queue = new LinkedList<>();
			
			for(int h=0; h<H; h++) {
				for(int w=0; w<W; w++) {
					map[h][w] = sc.nextInt();
				}
			}
			
			ans = 0;
			for(int h=0; h<H; h++) {
				for(int w=0; w<W; w++) {
					if(map[h][w]==1 && !visit[h][w]) {
						queue.add(new Point(h, w));
						visit[h][w] = true;
						bfs();
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}
	
	
	static void bfs() {
		
		while(!queue.isEmpty()) {
			Point n = queue.poll();
			for(int d=0; d<8; d++) {
				int ni = n.i + di[d];
				int nj = n.j + dj[d];
				if(ni>=0 && ni<H && nj>=0 && nj<W 
						&& map[ni][nj]==1 && !visit[ni][nj]) {
					queue.add(new Point(ni, nj));
					visit[ni][nj] = true;
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
