package BOJ;

import java.util.Scanner;

public class Boj1074Z_1 {
	static int N, R, C;
	static int cnt;
	static boolean flag;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		
		makeZ(0, 0, 1<<N, 1<<N);
		System.out.println(cnt);
	}
	
	static void makeZ(int si, int sj, int ei, int ej) {
		if(!flag) { // ���ϴ� ��ǥ�� ������ ��� �׳� ������.
			if(ei-si == 2) { // Z�� �׸����� �ִ�
				for(int i=si; i<ei; i++) {
					for(int j=sj; j<ej; j++) {
						if(i==R && j==C) {
							flag = true;
							return;
						}
						cnt++;
					}
				}
				return;			
			} else { // ������ �ؾ��Ѵٸ�,
				int mi = (si+ei)/2;
				int mj = (sj+ej)/2;
				
				makeZ(si, sj, mi, mj);
				makeZ(si, mj, mi, ej);
				makeZ(mi, sj, ei, mj);
				makeZ(mi, mj, ei, ej);
			}
		}
		return;
	}
}
