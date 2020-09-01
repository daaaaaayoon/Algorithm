package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Swea1238Contact_ver1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = 10; 
		for(int tc=1; tc<=TC; tc++) {
			
			int N = sc.nextInt(); // 입력되는 갯수
			int start = sc.nextInt(); // 시작점
			
			int[][] map = new int[101][101];
			boolean[] visited = new boolean[101];
			
			for(int i=0; i<N/2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				map[from][to] = 1;
			}
			
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(start, 0)); // 시작정점과 초기거리0을 넣음
			visited[start] = true;
			
			int max = 0, ans = 0;
			while(!q.isEmpty()) {
				
				Point n = q.poll();
				
				if(n.dist > max) { // 거리가 먼 애들이 나타남!
					max = n.dist;
					ans = 0; // 초기화! 얘네부터 다시 max 비교할거야.
				}
				ans = Math.max(n.num, ans);
				
				for(int i=1; i<=100; i++) {
					if(map[n.num][i]==1 && !visited[i]) {
						q.add(new Point(i, n.dist+1));
						visited[i] = true;
					}
				}
			} // while end
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static class Point{
		int num, dist; // 학생번호와 출발점으로부터의 거리
		Point(int n, int dist){
			this.num = n;
			this.dist = dist;
		}
	}
}
