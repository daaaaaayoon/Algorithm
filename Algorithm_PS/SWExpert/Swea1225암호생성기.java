package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Swea1225암호생성기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			
			int T = sc.nextInt(); // 테스트케이스의 번호
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				q.add(sc.nextInt());
			}
			int cnt = 1;
			while (true) {
				
				int n = q.poll();
				
				if(cnt == 6) cnt=1;
				n -= cnt;
				if (n <= 0) {
					q.add(0);
					break;
				}
				q.add(n);
				cnt++;
			}
			
			System.out.print("#" + T + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
		}

	}
}
