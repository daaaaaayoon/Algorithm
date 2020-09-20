package BOJ;

import java.util.Scanner;

public class Boj2605줄세우기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 학생 수
		int[] num = new int[N]; // 학생들이 뽑은 번호가 저장되는 배열
		int[] ans = new int[N]; // 학생의 순서가 저장되는 배열
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		
		ans[0] = 1; // 1번 학생은 무조건 0을 뽑는다.
		for(int i=1; i<N; i++) {
			
			// num[i]만큼의 숫자들을 밀어버리고,
			for(int j=i-1; j>=(i-num[i]); j--) {
				ans[j+1] = ans[j];
			}
			
			// 지금의 학생 번호를 순서에 추가한다.
			ans[i-num[i]] = i+1;
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(ans[i]+" ");
		}
	}
}
