package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1931_회의실배정 {
	
	static class Meeting implements Comparable<Meeting>{
		
		int start, end;
		
		Meeting(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			if(this.end == o.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Meeting[] arr = new Meeting[N];
		
		for(int i=0; i<N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			arr[i] = new Meeting(start, end);
		}
		
		Arrays.sort(arr);
		
		int nowAvailable = 0;
		int ans = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i].start >= nowAvailable) {
				nowAvailable = arr[i].end;
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
}
