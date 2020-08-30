package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Swea1208Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = 10;
		for(int tc=1; tc<=TC; tc++) {
			
			int ans = 0;
			int dump = sc.nextInt();
			int[] height = new int[100];
			
			for(int i=0; i<100; i++) {
				height[i] = sc.nextInt();
			}
			
			for(int d=0; d<dump; d++) {
				
				Arrays.sort(height);
				
				if(height[99]-height[0]<=1)
					break;
				
				height[99]--;
				height[0]++;
			}
			
			Arrays.sort(height); // 정렬 마지막 한번더해주어야한다.
			ans = height[99]-height[0];
			System.out.println("#"+tc+" "+ans);
		}
	}
}
