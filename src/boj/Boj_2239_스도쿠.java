package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2239_스도쿠 {

	static int N = 9;
	static ArrayList<Integer> arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		
		go(0,0,map);
		
	}

	private static boolean go(int i, int j, int[][] map) {
		int[][] newMap = new int[N][N];
		
		if(i==8 && j==9) {
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			}
			return true;
		}
		
		if(j==9) {
			if(go(i+1, 0, map)) return true;
			return false;
		}
		
		if(map[i][j]!=0) {
			if(go(i, j+1, map)) return true;
		}else {
			copy(map, newMap);
			
			check(i, j, map);
			
			int[] count = new int[10];
			for(int t=0; t<arr.size(); t++) {
				count[arr.get(t)]++;
			}
			for(int t=1; t<=9; t++) {
				if(count[t]==0) {
					newMap[i][j] = t;
					if(go(i, j+1, newMap)) return true;
				}
			}
			
		}
		return false;
		
	}

	private static void copy(int[][] map, int[][] newMap) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}

	private static void check(int i, int j, int[][] map) {
		arr = new ArrayList<Integer>();
		
		int c = 0;
		while(true) {
			if(map[i][c]!=0) arr.add(map[i][c]);
			if(++c==9) break;
		}
		int r = 0;
		while(true) {
			if(map[r][j]!=0) arr.add(map[r][j]);
			if(++r==9) break;
		}
		int si = 0, sj = 0;
		if(0<=i && i<3) si = 0;
		if(0<=j && j<3) sj = 0;
		if(3<=i && i<6) si = 3;
		if(3<=j && j<6) sj = 3;
		if(6<=i && i<9) si = 6;
		if(6<=j && j<9) sj = 6;
		
		for(int starti=si; starti<si+3; starti++) {
			for(int startj=sj; startj<sj+3; startj++) {
				if(map[starti][startj]!=0) {
					arr.add(map[starti][startj]);
				}
			}
		}
	}
	
	
}