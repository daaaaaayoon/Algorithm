package BOJ;

import java.util.Scanner;

public class Boj13300방배정 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 학생 수
		int K = sc.nextInt(); // 한 방에 배정 가능한 최대 인원 수
		
		int[] girl = new int[7]; // 1~6학년
		int[] boy = new int[7]; 
		
		// 학생의 성별과 학년을 입력받아 저장한다.
		for(int n=1; n<=N; n++) {
			int sex = sc.nextInt();
			int grade = sc.nextInt();
			
			if(sex == 0) { // 여자라면
				girl[grade]++;
			} else { // 남자라면
				boy[grade]++;
			}
		}
		
		// 학생 배정을 위한 최소한의 방의 수를 출력한다.
		int ans = 0;
		for(int g=1; g<=6; g++) { // 1학년부터 6학년까지
			
			// 여자 방
			while(true) {
				if(girl[g]<=K) break;
				girl[g]-=K;
				ans++;
			}
			if(girl[g]!=0) ans++; // 0인 경우 방은 필요가 없다.
			
			// 남자 방
			while(true) {
				if(boy[g]<=K) break;
				boy[g]-=K;
				ans++;
			}
			if(boy[g]!=0) ans++; // 0인 경우 방은 필요가 없다.
			
		}
		System.out.println(ans);
	}
}
