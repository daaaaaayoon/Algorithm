package BOJ;

import java.util.Scanner;

public class Boj2605�ټ���� {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // �л� ��
		int[] num = new int[N]; // �л����� ���� ��ȣ�� ����Ǵ� �迭
		int[] ans = new int[N]; // �л��� ������ ����Ǵ� �迭
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		
		ans[0] = 1; // 1�� �л��� ������ 0�� �̴´�.
		for(int i=1; i<N; i++) {
			
			// num[i]��ŭ�� ���ڵ��� �о������,
			for(int j=i-1; j>=(i-num[i]); j--) {
				ans[j+1] = ans[j];
			}
			
			// ������ �л� ��ȣ�� ������ �߰��Ѵ�.
			ans[i-num[i]] = i+1;
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(ans[i]+" ");
		}
	}
}
