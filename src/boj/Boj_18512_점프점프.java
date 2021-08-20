package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_18512_점프점프 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int H1 = sc.nextInt();
		int H2 = sc.nextInt();
		
		int MaxH1 = H1 + 10000;
		int MaxH2 = H2 + 10000;
		
		int ans = 0;
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(H1);
		while(true) {
			H1 = H1 + X; 
			if(H1 >= MaxH1) break;
			arr.add(H1);
		}
		
		int cnt = 0;
		while(true) {
			
			H2 = H2 + Y*cnt;
			if(cnt==0) cnt = 1;
			if(H2 >= MaxH2) {
				ans = -1;
				break;
			}
			
			for(int i=0; i<arr.size(); i++) {
				if(arr.get(i) == H2) {
					ans = H2;
				}
			}
			if(ans!=0) break;
		}
		System.out.println(ans);
	}

}