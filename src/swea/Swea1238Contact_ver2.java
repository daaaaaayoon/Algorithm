package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Swea1238Contact_ver2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = 10; 
		for(int tc=1; tc<=TC; tc++) {
			
			int N = sc.nextInt(); // �ԷµǴ� ������ ����
			int start = sc.nextInt(); // ������
			
			int[][] map = new int[101][101];
			boolean[] visited = new boolean[101];
			
			for(int i=0; i<N/2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				map[from][to] = 1;
			}
			
			Queue<Integer> q = new LinkedList<>();
			q.add(start);
			visited[start] = true;
			
			int ans = 0; // ��������� ���� �� ������ ���� ����
			while(!q.isEmpty()) {
				ans = 0; // �Ÿ��� ���ŵǾ����Ƿ� max�� 0���� �ٲ���
				int qsize = q.size();
				for(int s=0; s<qsize; s++) {
					int n = q.poll();
					ans = Math.max(ans, n); // ���� �Ÿ��� �����ϴ� ��ȣ�� �ִ�
					for(int i=1; i<101; i++) {
						if(map[n][i]==1 && !visited[i]) {
							q.add(i);
							visited[i] = true;
						}
					}
				}
			} // while end
			
			System.out.println("#"+tc+" "+ans);
		}
		
	}
	
}
