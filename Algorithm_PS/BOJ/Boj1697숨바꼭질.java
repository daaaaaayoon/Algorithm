package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1697¼û¹Ù²ÀÁú {
	
	static int N, K, sec;
	static boolean[] visit;
	static Queue<Integer> queue;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		visit = new boolean[100001]; 
		queue = new LinkedList<>();
		
		bfs();
		System.out.println(sec);
	}
	
	static void bfs() {
		
		queue.add(N);
		visit[N] = true;
		
		while(!queue.isEmpty()) {
			
			int qSize = queue.size();
			
			for(int s=0; s<qSize; s++) {
				
				int n = queue.poll();
				
				if(n==K) return;
				
				if(n-1>=0 && !visit[n-1]) {
					queue.add(n-1);
					visit[n-1] = true;
				}
				if(n+1<=100000 && !visit[n+1]) {
					queue.add(n+1);
					visit[n+1] = true;
				}
				if(n*2<=100000 && !visit[n*2]) {
					queue.add(n*2);
					visit[n*2] = true;
				}
			}
			
			sec++;
		}
	}
}
