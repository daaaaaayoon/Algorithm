package boj;

import java.util.Scanner;

public class Boj_1463_1로만들기_DP {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// D[i] : i�� 1�� ����� ���� �ʿ��� ������ �ּ� Ƚ��
		int[] D = new int[N+1];
		
		int min;
		for(int i=2; i<=N; i++) {
			
			min = Integer.MAX_VALUE;
			
			if(i%3==0 && D[i/3]+1<min) min = D[i/3]+1;
			if(i%2==0 && D[i/2]+1<min) min = D[i/2]+1;
			if(D[i-1]+1<min) min = D[i-1]+1;
			
			D[i] = min;
		}
		
		System.out.println(D[N]);
	}
}
