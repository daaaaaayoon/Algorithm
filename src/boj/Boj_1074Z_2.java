package boj;

import java.util.Scanner;

public class Boj_1074Z_2 {
	
	static int N, r, c;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		System.out.println(function(N, r, c));
	}

	static int function(int n, int r, int c) {
		if(n == 0) return 0;
		int half = 1<<(n-1);
		if(r < half && c < half) return function(n-1, r, c);
		if(r < half && c >= half) return half*half + function(n-1, r, c-half);
		if(r >= half && c < half) return 2*half*half + function(n-1, r-half, c);
		return 3*half*half + function(n-1, r-half, c-half);
	}
	
}
