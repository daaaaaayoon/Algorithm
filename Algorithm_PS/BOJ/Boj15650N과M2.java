package BOJ;

import java.util.Scanner;

public class Boj15650N��M2 {
	
	// 1���� N������ �ڿ��� �߿��� �ߺ����� M���� �� ����
	// �� ������ �������� => ����!
	static int N, M;
	static int[] ans; // �ϼ��� ������ ���� �迭
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		ans = new int[M];
		
		// 0��°�� ���ڸ� ������ ����. 1������ ��������!
		combination(0, 1);
	}
	
	static void combination(int cnt, int start) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i<=N; i++) {
			ans[cnt] = i;
			// ���� ���ڸ� ���������µ�, ���� ���� �ͺ��� ���� ���ڸ� �̾ƾ��� :)
			combination(cnt+1, i+1); 
		}
	}
}
