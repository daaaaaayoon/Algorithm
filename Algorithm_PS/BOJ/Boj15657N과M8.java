package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Boj15657N��M8 {
	// N���� �ڿ��� �߿��� M���� �� ���� + ���� ���� ������ ��� �ȴ� + �������� => �ߺ�����
	// �Է¹��� ���ڵ�� �ߺ� ������ ���� ����ϴ� ����
	
	static int N, M;
	static int[] input, ans;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		input = new int[N];
		ans = new int[M];
		sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		Arrays.sort(input); // ���������� �����ϴ� ������ ����ϱ� ���ؼ� ����
		
		comb(0, 0);
		
		System.out.println(sb.toString());
	}
	
	static void comb(int cnt, int now) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(ans[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=now; i<N; i++) {
			ans[cnt] = input[i];
			comb(cnt+1, i);
		}
	}
	
}
