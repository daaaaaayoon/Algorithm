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
		
//		// A<B��� ������ �����Ƿ� �ʿ����� ������ ���ٸ� �˾Ƽ� ã�ƾ��ϴ� ����!		
//		// A�� B���� ū ���� ���� �������� ����. 
//		if(A > B) {
//			System.out.println(-1);
//			return;
//		}else if(A == B) { // A�� B�� ���� ���� 0 + 1
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
					
					// 10�� 9�� = 10��
					// int���� ������ 20���� �Ѿ�� ��찡 ���� => 10�� * 10
					long tmp = 0;
					if(i==0) {
						tmp = n.x * 2;
					}else {
						// ���� ���ڿ��� �ٲ��� �ʾƵ� ��.
						tmp = n.x * 10 + 1;
					}
					
					// �� ������ ���ڰ� ��� Ŀ���� ���ۿ� �����Ƿ� 
					if(tmp <= B) {
						queue.add(new Pair(tmp, n.cnt+1));
					}
				}
			}
		}
		System.out.println(-1);
	}
}
