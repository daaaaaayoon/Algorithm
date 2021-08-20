package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_5427_불 {
	static int w, h, ans;
	static char[][] map;
	static Queue<Point> qFire;
	static Queue<Point> qSang;

	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new char[h][w];
			qFire = new LinkedList<>();
			qSang = new LinkedList<>();
			
			for(int i=0; i<h; i++) {
				map[i] = br.readLine().toCharArray();
				for(int j=0; j<w; j++) {
					if(map[i][j]=='@') {
						qSang.add(new Point(i, j));
					}else if(map[i][j]=='*') {
						qFire.add(new Point(i, j));
					}
				}
			}
			
			ans = 0;
			bfs();
			System.out.println(ans==0 ? "IMPOSSIBLE" : ans);
		} // tc end
	}
	
	static void bfs() {
		
		int time = 0;
		
		while(!qSang.isEmpty()) {
			time++;
			
			int fsize = qFire.size();
			for(int s=0; s<fsize; s++) {
				Point f = qFire.poll();
				for(int d=0; d<4; d++) {
					int ni = f.i + di[d];
					int nj = f.j + dj[d];
					if(0<=ni && ni<h && 0<=nj && nj<w && (map[ni][nj]=='@' || map[ni][nj]=='.')) {
						qFire.add(new Point(ni, nj));
						map[ni][nj] = '*';
					}
				}
			}
			
			int ssize = qSang.size();
			for(int s=0; s<ssize; s++) {
				Point sang = qSang.poll();
				for(int d=0; d<4; d++) {
					int ni = sang.i + di[d];
					int nj = sang.j + dj[d];
					if(ni<0 || ni>=h || nj<0 || nj>=w) {
						ans = time;
						return;
					}
					if(0<=ni && ni<h && 0<=nj && nj<w && map[ni][nj]=='.') {
						qSang.add(new Point(ni, nj));
						map[ni][nj] = '@';
					}
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
