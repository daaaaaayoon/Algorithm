package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj18513샘터 {
	
	static final int F = 100000000;
	static int N, K;
	static long ans;
	static boolean[] visit;
	static Queue<Point> queue;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		visit = new boolean[2*F+1];
		queue = new LinkedList<>();
		ans = 0;
		
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			queue.add(new Point(x, 0));
			visit[x+F] = true;
		}
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			
			Point n = queue.poll();
			ans += n.depress;
			
			if(++cnt >= N+K) break;
			
			// 아래처럼 하지 않고 delta를 사용해도됨.
			if(n.x-1 >= -F && !visit[(n.x-1)+F]) {
				queue.add(new Point(n.x-1, n.depress+1));
				visit[(n.x-1)+F] = true;
			}
			if(n.x+1 <= F && !visit[(n.x+1)+F]) {
				queue.add(new Point(n.x+1, n.depress+1));
				visit[(n.x+1)+F] = true;
			}
		}
		
		System.out.println(ans);
	}
	
	static class Point{
		int x;
		int depress;
		Point(int x, int depress){
			this.x = x;
			this.depress = depress;
		}
	}
}
