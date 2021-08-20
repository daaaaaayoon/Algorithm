package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1463_1로만들기_BFS {
	
	static int N, ans;
	static Queue<Integer> queue;
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		queue = new LinkedList<>();
		visited = new boolean[N+1];
		
		queue.add(N);
		visited[N] = true;
		
		bfs();
		
		System.out.println(ans);
	}
	
	static void bfs() {
		
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			
			int qSize = queue.size();
			
			for(int s=0; s<qSize; s++) {
				int n = queue.poll();
				
				if(n==1) {
					ans = cnt;
					return;
				}
				
				if(n%3==0 && !visited[n/3]) {
					visited[n/3] = true;
					queue.add(n/3);
				}
				if(n%2==0 && !visited[n/2]) {
					visited[n/2] = true;
					queue.add(n/2);
				}
				if(n-1>=1 && !visited[n-1]) {
					visited[n-1] = true;
					queue.add(n-1);
				}
			}
			cnt++;
		}
	}
}
