package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy숫자카드게임 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// 각 행을 저장할 임시 배열
		int[] arr = new int[M];
		int ans = 0;
		
		for(int n=0; n<N; n++) {
			// 현재 행을 입력받고 오름차순 정렬
			for(int m=0; m<M; m++) {
				arr[m] = sc.nextInt();
			}
			Arrays.sort(arr);
			// 가장 작은 수들 중에 큰 값을 찾는다.
			ans = Math.max(ans, arr[0]);
		}
		
		System.out.println(ans);
	}
	
}
