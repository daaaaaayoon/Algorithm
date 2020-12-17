package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy����ī����� {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// �� ���� ������ �ӽ� �迭
		int[] arr = new int[M];
		int ans = 0;
		
		for(int n=0; n<N; n++) {
			// ���� ���� �Է¹ް� �������� ����
			for(int m=0; m<M; m++) {
				arr[m] = sc.nextInt();
			}
			Arrays.sort(arr);
			// ���� ���� ���� �߿� ū ���� ã�´�.
			ans = Math.max(ans, arr[0]);
		}
		
		System.out.println(ans);
	}
	
}
