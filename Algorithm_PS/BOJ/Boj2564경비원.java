package BOJ;

import java.util.Scanner;

// ���簢���� ���ڷ� �� ��ġ��! => �� �� �� ��
public class Boj2564���� {
	
	static int W, H, N; // ���� ���� ������ ��
	static int[] loc; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		W = sc.nextInt();
		H = sc.nextInt();
		N = sc.nextInt();
		
		int total = 2*W+2*H;
		
		loc = new int[N+1]; // ������ ��ġ, �������� �������� ��ġ
		for(int i=0; i<=N; i++) { // ������ ��ǥ��
			int dir = sc.nextInt();
			int len = sc.nextInt();
			switch(dir) {
			case 1: // ����
				loc[i] = len;
				break;
			case 2: // ����
				loc[i] = 2*W+H-len;
				break;
			case 3: // ����
				loc[i] = 2*(W+H)-len;
				break;
			case 4: // ����
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
