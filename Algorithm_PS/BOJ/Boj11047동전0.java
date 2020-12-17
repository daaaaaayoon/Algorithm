package BOJ;

import java.util.Scanner;

public class Boj11047����0 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] coins = new int[N];
		for(int n=0; n<N; n++) {
			coins[n] = sc.nextInt();
		}
		
		int ans = 0; // ���� ������ �ּڰ�
		// ������ ������ �ּҰ� �Ǳ� ���� ���� ū �������� �����Ѵ�
		for(int n=N-1; n>=0; n--) {
			// K�� ������ ��ġ���� ũ�ų� ���ٸ�,
			if(K >= coins[n]) {
				// K�� ������ ��ġ�� ���� ��ŭ ans ����
				ans += K/coins[n];
				// K�� ������ ��ġ�� ���� �������� K�� �ֱ�
				K %= coins[n];
			}
		}
		System.out.println(ans);
	}
	
}
