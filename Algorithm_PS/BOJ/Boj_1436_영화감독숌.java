package Boj;

import java.util.Scanner;

public class Boj_1436_¿µÈ­°¨µ¶¼ò {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int sCnt = 0;
		int num = 666;
		int ans = 0;
		while(true) {
				
			String str = Integer.toString(num);
			if(str.contains("666")) {
				ans = num;
				if(++sCnt == N) break;
			}
			num++;
			
		}
		
		System.out.println(num);
		
	}
	
}
