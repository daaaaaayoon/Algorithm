package greedy;

import java.util.Scanner;

public class Greedy1�̵ɶ����� {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int cnt = 0;
		while(true) {
			// 1. 1�� ���� ����
			// K�� �������� ���� ���� ���� �����ϴ� �� target
			int target = (N/K) * K;
			cnt += (N - target);
			N = target;
			// N�� K���� ���� �� (�� �̻� ���� �� ���� ��)Ż�� 
			if(N < K) break;
			// 2. K�� ������ ����
			N /= K;
			++cnt;
		}
		cnt += (N-1);
		System.out.println(cnt);
	}
	
}
