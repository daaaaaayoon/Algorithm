package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2667단지번호붙이기_BFS {
	
	static int N;
	static ArrayList<Integer> ans;
	static Queue<Point> queue;
	static int[][] map;
	static boolean[][] visit;
	static int[] di= {0,0,-1,1};
	static int[] dj= {1,-1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		ans = new ArrayList<>();
		queue = new LinkedList<>();
		map = new int[N][N];
		visit = new boolean[N][N];
		
		// 입력 저장
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = line.charAt(j)-48;
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1 && !visit[i][j]) {
					queue.add(new Point(i, j));
					visit[i][j] = true;
					bfs();
				}
			}
		}
		
		Collections.sort(ans);
		
		System.out.println(ans.size());
		for(int a : ans) {
			System.out.println(a);
		}
	}
	
	static void bfs() {
		
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			Point n = queue.poll();
			cnt++;
			for(int d=0; d<4; d++) {
				int ni = n.i + di[d];
				int nj = n.j + dj[d];
				if(ni>=0 && ni<N && nj>=0 && nj<N && 
						map[ni][nj]==1 && !visit[ni][nj]) {
					queue.add(new Point(ni, nj));
					visit[ni][nj] = true;
				}
			}
		}
		
		ans.add(cnt);
	}
	
	static class Point{
		int i, j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
}
