package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Boj15655N��M6 {
	// N���� �ڿ��� �߿��� M���� �� ���� + �� ������  �������� => ����
	// �Է¹��� ���ڷ� ������ ����� ����ϴ� ����
	
	static int N, M;
	static int[] input, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		input = new int[N];
		ans = new int[M];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		Arrays.sort(input); // ���������� �����ϴ� ������ ����ϱ� ���ؼ� ����
		
		comb(0, 0);
		
	}
	
	static void comb(int cnt, int now) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=now; i<N; i++) {
			ans[cnt] = input[i];
			comb(cnt+1, i+1);
		}
	}
}
