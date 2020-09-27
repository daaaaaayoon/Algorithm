package BOJ;

import java.util.Scanner;

public class Boj11729�ϳ���ž�̵����� {
	
	static StringBuilder sb;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		sb = new StringBuilder();
		// �ű� Ƚ�� K = (1<<N)-1
		sb.append((1<<N)-1);
		sb.append("\n");
		func(N, 1, 3);
		System.out.println(sb.toString());
	}
	
	static void func(int n, int a, int b) {
		
		if(n == 1) {
			sb.append(a+" "+b+"\n");
			return;
		}
		func(n-1, a, 6-a-b);
		sb.append(a+" "+b+"\n");
		func(n-1, 6-a-b, b);
		
	}
}
