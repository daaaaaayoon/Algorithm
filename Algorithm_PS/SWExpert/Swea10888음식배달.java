package SWEA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Swea10888음식배달 {
	
	static int N, sum, ans;
	static int[][] map;
	static int[][] dist; // 배달집이 선택된 부분집합마다 집에서 배달집까지의 최소 거리를 담는 배열
	static ArrayList<Point> delivery; // 배달집들의 위치를 담는 순차리스트
	static boolean[] isSelected; // 배달집들의 부분집합을 만들기 위한 배열
	static ArrayList<Point> house; // 집들의 위치를 담는 순차리스트
	static ArrayList<Point> select; // 선택된 배달집들을 담는 순차리스트 
	
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			
			N = sc.nextInt();
			
			map = new int[N][N];
			delivery = new ArrayList<>();
			house = new ArrayList<>();
			ans = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j]>=2) { // 음식 배달점
						delivery.add(new Point(i, j));
					}else if(map[i][j]==1) { // 집
						house.add(new Point(i, j));
					}
				}
			}
			isSelected = new boolean[delivery.size()];
			
			subset(0);
			
			System.out.println("#"+tc+" "+ans);
		}
		
	}
	
	static void subset(int cnt) {
		
		if(cnt == delivery.size()) {
			
			// 새로운 부분집합에서의 초기화 작업
			select = new ArrayList<>();
			dist = new int[N][N];
			for(int i=0; i<N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			sum = 0;
			
			for(int n=0; n<delivery.size(); n++) {
				if(isSelected[n]) { // 선택된 애들만
					Point p = delivery.get(n);
					select.add(p); // 순차리스트에 추가한다.
					sum += map[p.i][p.j]; // 운용비를 더해준다.
				}
			}
			
			if(select.size()!=0) { // 공집합이 아닌 경우에만 -> 아 굳이 안해도 된다.
				
				for(int i=0; i<select.size(); i++) {
					
					Point n = select.get(i);
					
					for(int t=0; t<house.size(); t++) {
						
						int hi = house.get(t).i;
						int hj = house.get(t).j;
						
						int d = Math.abs(n.i-hi) + Math.abs(n.j-hj);
						
						if(dist[hi][hj] > d) { // 저장되어 있는 값을 최소로 갱신
							dist[hi][hj] = d;
						}
					}
					
				}
				
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						// 집의 위치에 표시된 거리를 운용비에 누적하여 더해준다.
						if(dist[i][j]!= Integer.MAX_VALUE) {
							sum += dist[i][j];
						}
					}
				}
				// 최소값 갱신
				ans = Math.min(ans, sum);
			}
			return;
			
		}else { // 부분집합 만들기
			isSelected[cnt] = true;
			subset(cnt+1);
			isSelected[cnt] = false;
			subset(cnt+1);
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
