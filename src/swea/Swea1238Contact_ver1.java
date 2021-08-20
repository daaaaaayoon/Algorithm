package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Swea1238Contact_ver1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = 10; 
		for(int tc=1; tc<=TC; tc++) {
			
			int N = sc.nextInt(); // �ԷµǴ� ����
			int start = sc.nextInt(); // ������
			
			int[][] map = new int[101][101];
			boolean[] visited = new boolean[101];
			
			for(int i=0; i<N/2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				map[from][to] = 1;
			}
			
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(start, 0)); // ���������� �ʱ�Ÿ�0�� ����
			visited[start] = true;
			
			int max = 0, ans = 0;
			while(!q.isEmpty()) {
				
				Point n = q.poll();
				
				if(n.dist > max) { // �Ÿ��� �� �ֵ��� ��Ÿ��!
					max = n.dist;
					ans = 0; // �ʱ�ȭ! ��׺��� �ٽ� max ���Ұž�.
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
		int num, dist; // �л���ȣ�� ��������κ����� �Ÿ�
		Point(int n, int dist){
			this.num = n;
			this.dist = dist;
		}
	}
}
