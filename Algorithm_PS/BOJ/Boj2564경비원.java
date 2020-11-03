package BOJ;

import java.util.Scanner;

// 직사각형을 일자로 쭉 펼치자! => 북 동 남 서
public class Boj2564경비원 {
	
	static int W, H, N; // 가로 세로 상점의 수
	static int[] loc; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		W = sc.nextInt();
		H = sc.nextInt();
		N = sc.nextInt();
		
		int total = 2*W+2*H;
		
		loc = new int[N+1]; // 상점의 위치, 마지막은 동근이의 위치
		for(int i=0; i<=N; i++) { // 동근이 좌표도
			int dir = sc.nextInt();
			int len = sc.nextInt();
			switch(dir) {
			case 1: // 북쪽
				loc[i] = len;
				break;
			case 2: // 남쪽
				loc[i] = 2*W+H-len;
				break;
			case 3: // 서쪽
				loc[i] = 2*(W+H)-len;
				break;
			case 4: // 동쪽
				loc[i] = len+W;
				break;
			}
		}
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			int temp = Math.abs(loc[N]-loc[i]);
			if(temp<W+H) {
				ans+=temp;
			}else {
				ans+=total-temp;
			}
		}
		
		System.out.println(ans);
	}
	
}
