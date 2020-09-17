package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj10026적록색약_BFS {
	
	static int N, ans1, ans2; 
	static char[][] map;
	static boolean[][] visit;
	static Queue<Point> queue;
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		queue = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// < 비색약자 >
		visit = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					bfs(i, j);
					ans1++;
				}
			}
		}
		
		// < 색약자 >
		
		// 색약자가 보는 map으로 만든다.
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]=='R') {
					map[i][j] = 'G';
				}
			}
		}
		
		visit = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					bfs(i, j);
					ans2++;
				}
			}
		}
		
		System.out.println(ans1+" "+ans2);
	}
	
	static void bfs(int i, int j) {
		
		visit[i][j] = true;
		queue.add(new Point(i, j));
		
		while(!queue.isEmpty()) {
			Point n = queue.poll();
			
			for(int d=0; d<4; d++) {
				int ni = n.i + di[d];
				int nj = n.j + dj[d];
				if(ni>=0 && ni<N && nj>=0 && nj<N 
						&& map[i][j] == map[ni][nj] && !visit[ni][nj]) {
					queue.add(new Point(ni, nj));
					visit[ni][nj] = true;
				}
			}
		}
		
	}
	
	static class Point{
		int i;
		int j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
}
