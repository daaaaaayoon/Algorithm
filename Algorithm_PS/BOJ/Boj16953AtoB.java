package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj16953AtoB {
	
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
		
//		// A<B라는 조건이 있으므로 필요하지 않지만 없다면 알아서 찾아야하는 조건!		
//		// A가 B보다 큰 경우는 도달 가능하지 않음. 
//		if(A > B) {
//			System.out.println(-1);
//			return;
//		}else if(A == B) { // A와 B가 같은 경우는 0 + 1
//			System.out.println(1);
//			return;
//		}
		
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
					
					// 10의 9승 = 10억
					// int형의 범위인 20억을 넘어가는 경우가 생김 => 10억 * 10
					long tmp = 0;
					if(i==0) {
						tmp = n.x * 2;
					}else {
						// 굳이 문자열로 바꾸지 않아도 됨.
						tmp = n.x * 10 + 1;
					}
					
					// 이 문제는 숫자가 계속 커지는 경우밖에 없으므로 
					if(tmp <= B) {
						queue.add(new Pair(tmp, n.cnt+1));
					}
				}
			}
		}
		System.out.println(-1);
	}
}
