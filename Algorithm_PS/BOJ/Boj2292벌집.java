package BOJ;

import java.util.Scanner;

public class Boj2292¹úÁý {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N == 1) {
			System.out.println("1");
			return;
		}
		
		int i=2, j=0, dist=1;
		while(true) {
			
			int start = i;
			dist++;
			
			if(start<=N && N<start+(6*(j+1))) { 
				System.out.println(dist);
				return;
			}
			
			i=i+(6*++j);
		}
	}
	
}
