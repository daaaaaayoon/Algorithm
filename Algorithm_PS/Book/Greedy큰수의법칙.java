package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy큰수의법칙 {
	
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
		
		// 큰 수가 더해지는 횟수 계산하기
		int cnt = (M / (K+1)) * K; // 큰 수가 더해지는 횟수 (M/(K+1)=0 인 경우)
		cnt += M % (K+1); // M/(K+1)=0 인 경우를 처리
		
		int answer = 0;
		answer += cnt * first;
		answer += (M - cnt) * second;
		
		System.out.println(answer);
	}
	
}
