package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj2635수이어가기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = N/2;
		
		ArrayList<Integer> arr;
		
		int ans = Integer.MIN_VALUE;
		while(true) {
			
			arr = new ArrayList<>();
			arr.add(N);
			arr.add(K);
			
			int i=2;
			while(true) {
				int num = arr.get(i-2)-arr.get(i-1);
				if(num < 0) break;
				arr.add(num);
				i++;
			}
			
			if(arr.size() < ans) {
				System.out.println(ans);
				K--;
				break;
			}
			ans = arr.size();
			K++;
		}
		
		arr = new ArrayList<>();
		arr.add(N);
		arr.add(K);
		
		int i=2;
		while(true) {
			int num = arr.get(i-2)-arr.get(i-1);
			if(num < 0) break;
			arr.add(num);
			i++;
		}
		
		for(int a : arr) {
			System.out.print(a+" ");
		}
	}
	
}
