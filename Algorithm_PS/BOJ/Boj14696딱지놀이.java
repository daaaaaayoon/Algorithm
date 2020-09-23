package BOJ;

import java.util.Scanner;

public class Boj14696�������� {
	
	static int N; 
	static int[] acnt, bcnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		// ��Ÿ�� ���� (��� ������ �Ѵ� ���� �ִ�.)-> ������ ������ N*2�� �ؼ�,,
		for(int i=0; i<N; i++) { // ���� ����

			acnt = new int[5];
			bcnt = new int[5];
			
			// �� ���忡���� ī�� ������
			int NA = sc.nextInt();
			for(int n=0; n<NA; n++) {
				int num = sc.nextInt();
				acnt[num]++;
			}
			int NB = sc.nextInt();
			for(int n=0; n<NB; n++) {
				int num = sc.nextInt();
				bcnt[num]++;
			}
			
			// �º� �����ϱ�
			comp();
			
		}
	}
	
	static void comp() {
		for(int k=4; k>=1; k--) {
			if(acnt[k] > bcnt[k]) { // a�� �̱�
				System.out.println('A');
				return;
			}else if(acnt[k] < bcnt[k]) { // b�� �̱�
				System.out.println('B');
				return;
			}
		}
		System.out.println('D');
	}
}
