package greedy;

import java.util.Scanner;

public class Greedy1이될때까지 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int cnt = 0;
		while(true) {
			// 1. 1을 빼는 연산
			// K로 나눠지기 위한 수를 위해 빼야하는 수 target
			int target = (N/K) * K;
			cnt += (N - target);
			N = target;
			// N이 K보다 작을 때 (더 이상 나눌 수 없을 때)탈출 
			if(N < K) break;
			// 2. K로 나누는 연산
			N /= K;
			++cnt;
		}
		cnt += (N-1);
		System.out.println(cnt);
	}
	
}
