package BOJ;

import java.util.Scanner;

public class Boj15649N��M1 {
	
	// 1���� N������ �ڿ��� �߿��� �ߺ� ���� M���� �� ����
	// nPr
	static int N, M;
	static int[] ans; // ������� ������ ���� �迭
	static boolean[] used; // ���� �� ���õ�(����)���ڸ� �����ϱ� ����
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		ans = new int[M]; // M���� ���ڸ� ���� ����
		used = new boolean[N+1]; // �ε����� ����� ���� (1~N)
		
		permutation(0); // 0��° ���ں��� ���Ϸ� ����.
	}
	
	static void permutation(int cnt) {
		if(cnt == M) { // N���� ��� �����ߴ�!
			for(int i=0; i<M; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1; i<=N; i++) {
			if(!used[i]) {
				used[i] = true;
				ans[cnt] = i;
				permutation(cnt+1); // ���� ������ ���Ϸ� ����.
				used[i] = false;
			}
		}
	}
}
