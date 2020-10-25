package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1158요세푸스문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> q = new LinkedList<>();
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		System.out.print("<");
		
		// 1. 
		for(int k=0; k<K-1; k++) {
			int num = q.poll();
			q.add(num);
		}
		System.out.print(q.poll());
		
		// 2. 
		while(!q.isEmpty()) {
			for(int k=0; k<K-1; k++) {
				int num = q.poll();
				q.add(num);
			}
			System.out.print(", "+q.poll());
		}
		
		System.out.println(">");
		
	}
}
