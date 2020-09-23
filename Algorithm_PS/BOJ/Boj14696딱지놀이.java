package BOJ;

import java.util.Scanner;

public class Boj14696딱지놀이 {
	
	static int N; 
	static int[] acnt, bcnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		// 런타임 에러 (어딘가 범위를 넘는 곳이 있다.)-> 라운드의 개수를 N*2로 해서,,
		for(int i=0; i<N; i++) { // 라운드 시작

			acnt = new int[5];
			bcnt = new int[5];
			
			// 한 라운드에서의 카드 정보들
			int NA = sc.nextInt();
			for(int n=0; n<NA; n++) {
				int num = sc.nextInt();
				acnt[num]++;
			}
			int NB = sc.nextInt();
			for(int n=0; n<NB; n++) {
				int num = sc.nextInt();
				bcnt[num]++;
			}
			
			// 승부 결정하기
			comp();
			
		}
	}
	
	static void comp() {
		for(int k=4; k>=1; k--) {
			if(acnt[k] > bcnt[k]) { // a가 이김
				System.out.println('A');
				return;
			}else if(acnt[k] < bcnt[k]) { // b가 이김
				System.out.println('B');
				return;
			}
		}
		System.out.println('D');
	}
}
