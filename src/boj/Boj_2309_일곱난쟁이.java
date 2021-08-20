package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2309_일곱난쟁이 {
	
	static int N, R;
	static int[] dwarf9H;
	static int[] dwarf7H;
	static int[] ans;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = 9;
		R = 7;
		dwarf9H = new int[N];
		dwarf7H = new int[R];
		ans = new int[R];
		
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
