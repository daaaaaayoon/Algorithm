package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Greedyū���ǹ�Ģ {
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		int[] numbers = new int[N];
		for(int i=0; i<N; i++) {
			numbers[i] = sc.nextInt();
		}
		
		Arrays.sort(numbers);
		int first = numbers[N-1];
		int second = numbers[N-2];
		
		// ū ���� �������� Ƚ�� ����ϱ�
		int cnt = (M / (K+1)) * K; // ū ���� �������� Ƚ�� (M/(K+1)=0 �� ���)
		cnt += M % (K+1); // M/(K+1)=0 �� ��츦 ó��
		
		int answer = 0;
		answer += cnt * first;
		answer += (M - cnt) * second;
		
		System.out.println(answer);
	}
	
}
