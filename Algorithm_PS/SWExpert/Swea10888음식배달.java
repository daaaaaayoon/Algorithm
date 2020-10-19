package SWEA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Swea10888���Ĺ�� {
	
	static int N, sum, ans;
	static int[][] map;
	static int[][] dist; // ������� ���õ� �κ����ո��� ������ ����������� �ּ� �Ÿ��� ��� �迭
	static ArrayList<Point> delivery; // ��������� ��ġ�� ��� ��������Ʈ
	static boolean[] isSelected; // ��������� �κ������� ����� ���� �迭
	static ArrayList<Point> house; // ������ ��ġ�� ��� ��������Ʈ
	static ArrayList<Point> select; // ���õ� ��������� ��� ��������Ʈ 
	
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
					if(map[i][j]>=2) { // ���� �����
						delivery.add(new Point(i, j));
					}else if(map[i][j]==1) { // ��
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
			
			// ���ο� �κ����տ����� �ʱ�ȭ �۾�
			select = new ArrayList<>();
			dist = new int[N][N];
			for(int i=0; i<N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			sum = 0;
			
			for(int n=0; n<delivery.size(); n++) {
				if(isSelected[n]) { // ���õ� �ֵ鸸
					Point p = delivery.get(n);
					select.add(p); // ��������Ʈ�� �߰��Ѵ�.
					sum += map[p.i][p.j]; // ���� �����ش�.
				}
			}
			
			if(select.size()!=0) { // �������� �ƴ� ��쿡�� -> �� ���� ���ص� �ȴ�.
				
				for(int i=0; i<select.size(); i++) {
					
					Point n = select.get(i);
					
					for(int t=0; t<house.size(); t++) {
						
						int hi = house.get(t).i;
						int hj = house.get(t).j;
						
						int d = Math.abs(n.i-hi) + Math.abs(n.j-hj);
						
						if(dist[hi][hj] > d) { // ����Ǿ� �ִ� ���� �ּҷ� ����
							dist[hi][hj] = d;
						}
					}
					
				}
				
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						// ���� ��ġ�� ǥ�õ� �Ÿ��� ���� �����Ͽ� �����ش�.
						if(dist[i][j]!= Integer.MAX_VALUE) {
							sum += dist[i][j];
						}
					}
				}
				// �ּҰ� ����
				ans = Math.min(ans, sum);
			}
			return;
			
		}else { // �κ����� �����
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
