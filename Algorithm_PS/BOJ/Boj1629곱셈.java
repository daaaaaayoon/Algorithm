package BOJ;

import java.util.Scanner;

// O(logb)의 시간복잡도

// a^n * a^n = a^2n
// a^(2n+1) = a^n * a^n * a

// mod연산 : 23425336 * 262881 * 78933의 일의 자리는? 6*1*3 => 18%10 = 8
// 여기서의 10이 이 문제에서의 c라고 생각하면 됨!

public class Boj1629곱셈 {

	static int A, B, C;
	static long val;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		
		System.out.println(func(A, B, C));
	}
	
	static long func(int a, int b, int c){
		if(b == 1) return a % c; // a가 c보다 클 수도 있음
		val = func(a, b/2, c);
		val = val  * val % c;
		if(b%2 == 0) return val; // a^(2n) = a^n * a^n
		return val * a % c; // a^(2n+1) = a^n * a^n * a
	}
	
}
