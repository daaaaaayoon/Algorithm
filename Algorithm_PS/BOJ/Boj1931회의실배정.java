package BOJ;

import java.util.Arrays;
import java.util.Scanner;

// 오답 이유 : 회의시간이 같을 수도 있다는 조건을 놓침
// 그에 대한 반례로는 2 2 2 1 2 => arr이 정렬이 올바르게 되지 않음 => compareTo의 정렬 조건을 변경

// 2^31-1이라는 숫자는 int형으로 충분!

// Greedy문제로 회의가 가장 빨리 끝나는 순서대로 정렬한 후, 순서대로 선택해나가면 문제
public class Boj1931회의실배정 {
	
	// 회의의 시작시간과 끝 시간을 담을 Class
	static class Meeting implements Comparable<Meeting>{
		
		int start, end; // 시작시간과 끝시간
		
		Meeting(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			if(this.end == o.end) { // 끝나는 시간이 같은 경우에는
				return this.start - o.start; // 시작시간으로 정렬한다.
			}
			return this.end - o.end; // 끝나는 시간 오름차순 정렬
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
		
		int nowAvailable = 0; // 선택된 회의실의 끝나는 시간을 저장할 변수
		int ans = 0; // 회의실 개수를 세는 변수
		for(int i=0; i<arr.length; i++) {
			// 회의실을 사용 가능하면(이전에 선택한 회의실과 끝나는 시간이 같거나 크다면)
			if(arr[i].start >= nowAvailable) {
				// 이 회의실을 선택하자.
				nowAvailable = arr[i].end;
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
}
