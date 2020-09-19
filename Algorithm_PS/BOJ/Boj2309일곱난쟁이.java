package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2309�ϰ������� {
	
	static int N, R;
	static int[] dwarf9H;
	static int[] dwarf7H;
	static int[] ans;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = 9; // ��ȩ������
		R = 7; // �ϰ�������
		dwarf9H = new int[N];
		dwarf7H = new int[R];
		ans = new int[R]; // �������� Ű ���� 100�� �Ǵ� �迭 (����)
		
		for(int i=0; i<N; i++) {
			dwarf9H[i] = sc.nextInt();
		}
		
		Arrays.sort(dwarf9H);
		
		comb(0,0);
		
		for(int i=0; i<R; i++) {
			System.out.println(ans[i]);
		}
		
	}
	
	static void comb(int cnt, int start) {
		if(cnt == R) {
			int sum = 0;
			for(int i=0; i<R; i++) {
				sum += dwarf7H[i];
			}
			if(sum==100) {
				for(int i=0; i<R; i++) {
					ans[i]=dwarf7H[i];
				}
			}
			return;
		}
		for(int i=start; i<N; i++) {
			dwarf7H[cnt] = dwarf9H[i];
			comb(cnt+1, i+1);
		}
	}
	
}
