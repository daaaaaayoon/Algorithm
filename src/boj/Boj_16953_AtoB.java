package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_16953_AtoB {
	
	static int A, B;
	static Queue<Pair> queue;
	
	static class Pair{
		long x;
		int cnt;
		Pair(long x, int cnt){
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		
		queue = new LinkedList<>();
		queue.add(new Pair(A, 0));
		
		while(!queue.isEmpty()) {
			
			int qSize = queue.size();
			
			for(int s=0; s<qSize; s++) {
				Pair n = queue.poll();
				
				if(n.x == B) {
					System.out.println(n.cnt+1);
					return;
				}
				for(int i=0; i<2; i++) {
					
					long tmp = 0;
					if(i==0) {
						tmp = n.x * 2;
					}else {
						tmp = n.x * 10 + 1;
					}
					
					if(tmp <= B) {
						queue.add(new Pair(tmp, n.cnt+1));
					}
				}
			}
		}
		System.out.println(-1);
	}
}
