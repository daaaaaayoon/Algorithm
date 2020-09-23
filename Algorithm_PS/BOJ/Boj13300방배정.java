package BOJ;

import java.util.Scanner;

public class Boj13300����� {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // �л� ��
		int K = sc.nextInt(); // �� �濡 ���� ������ �ִ� �ο� ��
		
		int[] girl = new int[7]; // 1~6�г�
		int[] boy = new int[7]; 
		
		// �л��� ������ �г��� �Է¹޾� �����Ѵ�.
		for(int n=1; n<=N; n++) {
			int sex = sc.nextInt();
			int grade = sc.nextInt();
			
			if(sex == 0) { // ���ڶ��
				girl[grade]++;
			} else { // ���ڶ��
				boy[grade]++;
			}
		}
		
		// �л� ������ ���� �ּ����� ���� ���� ����Ѵ�.
		int ans = 0;
		for(int g=1; g<=6; g++) { // 1�г���� 6�г����
			
			// ���� ��
			while(true) {
				if(girl[g]<=K) break;
				girl[g]-=K;
				ans++;
			}
			if(girl[g]!=0) ans++; // 0�� ��� ���� �ʿ䰡 ����.
			
			// ���� ��
			while(true) {
				if(boy[g]<=K) break;
				boy[g]-=K;
				ans++;
			}
			if(boy[g]!=0) ans++; // 0�� ��� ���� �ʿ䰡 ����.
			
		}
		System.out.println(ans);
	}
}
