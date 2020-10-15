package BOJ;

import java.util.Arrays;
import java.util.Scanner;

// ���� ���� : ȸ�ǽð��� ���� ���� �ִٴ� ������ ��ħ
// �׿� ���� �ݷʷδ� 2 2 2 1 2 => arr�� ������ �ùٸ��� ���� ���� => compareTo�� ���� ������ ����

// 2^31-1�̶�� ���ڴ� int������ ���!

// Greedy������ ȸ�ǰ� ���� ���� ������ ������� ������ ��, ������� �����س����� ����
public class Boj1931ȸ�ǽǹ��� {
	
	// ȸ���� ���۽ð��� �� �ð��� ���� Class
	static class Meeting implements Comparable<Meeting>{
		
		int start, end; // ���۽ð��� ���ð�
		
		Meeting(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			if(this.end == o.end) { // ������ �ð��� ���� ��쿡��
				return this.start - o.start; // ���۽ð����� �����Ѵ�.
			}
			return this.end - o.end; // ������ �ð� �������� ����
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
		
		int nowAvailable = 0; // ���õ� ȸ�ǽ��� ������ �ð��� ������ ����
		int ans = 0; // ȸ�ǽ� ������ ���� ����
		for(int i=0; i<arr.length; i++) {
			// ȸ�ǽ��� ��� �����ϸ�(������ ������ ȸ�ǽǰ� ������ �ð��� ���ų� ũ�ٸ�)
			if(arr[i].start >= nowAvailable) {
				// �� ȸ�ǽ��� ��������.
				nowAvailable = arr[i].end;
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
}
