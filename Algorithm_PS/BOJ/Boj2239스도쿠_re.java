package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// NewMap을 안쓴 버전
public class Boj2239스도쿠_re {
	
	static int N = 9;
	static int[][] map;
	static ArrayList<Integer> arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		
		go(0,0);
		
	}
	
	// map (i,j)가 0 이 아니라면 숫자를 채우지않고 다음재귀로 넘어가고, 숫자가 0 이라면 숫자를 채우는 재귀함수
	private static boolean go(int i, int j) {
		
		if(i==8 && j==9) {
			// 정답 출력
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			}
			return true;
		}
		
		if(j==9) {
			if(go(i+1, 0)) return true;
			return false;
		}
		
		if(map[i][j]!=0) {
			if(go(i, j+1)) return true;
		}else {
			
			// 지금  map배열에 가로, 세로, 3x3에 어떠한 숫자가 있는지를 arr 리스트에 모아오는 함수
			check(i, j); 
			
			int[] count = new int[10];
			for(int t=0; t<arr.size(); t++) {
				count[arr.get(t)]++; // 숫자가 있는 것은 count배열에서 숫자가 증가되어있음
			}
			
			for(int t=1; t<=9; t++) {
				if(count[t]==0) { // arr 리스트에 없는 숫자는 넣어볼 수 있음
					map[i][j] = t; // map에 들어있는 값을 바꾸어서 재귀를 태워보자.
					if(go(i, j+1)) return true; // 그 배열을 가지고 재귀태우자.
				}
			}
			/* 이거 위치이ㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣ */
			map[i][j] = 0;
			
		}
		
		return false;
		
	}

	private static void check(int i, int j) {
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