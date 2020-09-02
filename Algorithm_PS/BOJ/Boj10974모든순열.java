package BOJ;

import java.util.Scanner;

public class Boj10974������ {
	
	static int N; // 1~N������ ��
	static int[] ans; // ������� ������ ������ �迭
	static boolean[] used; // ������ ����µ� ���ڰ� �������� �ƴ����� �Ǵ��ϱ����� �迭
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		ans = new int[N];
		used = new boolean[N+1];
		
		permutation(0); // 0��° �ڸ����� ���Ϸ�����.
		
	}
	
	static void permutation(int cnt) {
		if(cnt == N) { // ������ �ϳ� ��������ٸ�
			for(int i=0; i<N; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1; i<=N; i++) {
			if(!used[i]) {
				used[i] = true;
				ans[cnt] = i;
				permutation(cnt+1);
				used[i] = false;
			}
		}
	}
}
