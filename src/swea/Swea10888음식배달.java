package swea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Swea10888음식배달 {
	
	static int N, sum, ans;
	static int[][] map;
	static int[][] dist;
	static ArrayList<Point> delivery;
	static boolean[] isSelected;
	static ArrayList<Point> house;
	static ArrayList<Point> select;
	
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
					if(map[i][j]>=2) {
						delivery.add(new Point(i, j));
					}else if(map[i][j]==1) {
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
			
			select = new ArrayList<>();
			dist = new int[N][N];
			for(int i=0; i<N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			sum = 0;
			
			for(int n=0; n<delivery.size(); n++) {
				if(isSelected[n]) {
					Point p = delivery.get(n);
					select.add(p);
					sum += map[p.i][p.j];
				}
			}
			
			if(select.size()!=0) {
				
				for(int i=0; i<select.size(); i++) {
					
					Point n = select.get(i);
					
					for(int t=0; t<house.size(); t++) {
						
						int hi = house.get(t).i;
						int hj = house.get(t).j;
						
						int d = Math.abs(n.i-hi) + Math.abs(n.j-hj);
						
						if(dist[hi][hj] > d) {
							dist[hi][hj] = d;
						}
					}
					
				}
				
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(dist[i][j]!= Integer.MAX_VALUE) {
							sum += dist[i][j];
						}
					}
				}
				ans = Math.min(ans, sum);
			}
			return;
			
		}else {
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
