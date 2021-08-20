package boj;

import java.util.Scanner;

public class Boj_14696_딱지놀이 {
	
	static int N; 
	static int[] acnt, bcnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i=0; i<N; i++) {

			acnt = new int[5];
			bcnt = new int[5];
			
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
			
			comp();
			
		}
	}
	
	static void comp() {
		for(int k=4; k>=1; k--) {
			if(acnt[k] > bcnt[k]) {
				System.out.println('A');
				return;
			}else if(acnt[k] < bcnt[k]) {
				System.out.println('B');
				return;
			}
		}
		System.out.println('D');
	}
}
