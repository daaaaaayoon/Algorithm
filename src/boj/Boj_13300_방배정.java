package boj;

import java.util.Scanner;

public class Boj_13300_방배정 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] girl = new int[7];
		int[] boy = new int[7]; 
		
		for(int n=1; n<=N; n++) {
			int sex = sc.nextInt();
			int grade = sc.nextInt();
			
			if(sex == 0) {
				girl[grade]++;
			} else {
				boy[grade]++;
			}
		}
		
		int ans = 0;
		for(int g=1; g<=6; g++) {
			
			while(true) {
				if(girl[g]<=K) break;
				girl[g]-=K;
				ans++;
			}
			if(girl[g]!=0) ans++;
			
			while(true) {
				if(boy[g]<=K) break;
				boy[g]-=K;
				ans++;
			}
			if(boy[g]!=0) ans++;
			
		}
		System.out.println(ans);
	}
}
