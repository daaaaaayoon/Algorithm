package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea7793오나의여신님 {
	static int N, M, ans;
	static char[][] map;
	static Queue<Point> queueS;
	static Queue<Point> queueD;
	static int endi, endj;
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][];
			queueS = new LinkedList<>();
			queueD = new LinkedList<>();
			
			for(int i=0; i<N; i++) {
				map[i] = br.readLine().toCharArray();
				for(int j=0; j<M; j++) {
					if(map[i][j]=='S') {
						queueS.add(new Point(i, j));
					}else if(map[i][j]=='D'){
						endi = i; endj = j;
					}else if(map[i][j]=='*') {
						queueD.add(new Point(i, j));
					}
				}
			}
			
			ans=0;
			dfs();
			System.out.println("#"+tc+" "+(ans==0?"GAME OVER":ans));
		}
	}
	
	static void dfs() {
		int time = 0;
		while(!queueS.isEmpty()) {
			time++;
			
			int dsize = queueD.size();
			
			for(int s=0; s<dsize; s++) {
				Point n = queueD.poll();
				
				for(int d=0; d<4; d++) {
					int ni = n.i + di[d];
					int nj = n.j + dj[d];
					if(0<=ni && ni<N && 0<=nj && nj<M 
							&& (map[ni][nj]=='.'
							|| map[ni][nj]=='S')) { // 이부분 잘못 처리해서 답 안나왔었음
						queueD.add(new Point(ni, nj));
						map[ni][nj] = '*';
					}
				}
			}
			
			int ssize = queueS.size();
			
			for(int s=0; s<ssize; s++) {
				Point n = queueS.poll();
				
				for(int d=0; d<4; d++) {
					int ni = n.i + di[d];
					int nj = n.j + dj[d];
					if(0<=ni && ni<N && 0<=nj && nj<M 
							&& map[ni][nj]=='.') {
						queueS.add(new Point(ni, nj));
						map[ni][nj] = 'S';
					}
					if(ni==endi && nj==endj) {
						ans = time;
						return;
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
