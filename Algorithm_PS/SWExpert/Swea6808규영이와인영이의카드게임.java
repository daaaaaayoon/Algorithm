package SWEA;

import java.util.Scanner;

public class Swea6808�Կ��̿��ο�����ī����� {
	
	static int[] card;
	static int[] kyu;
	static int[] een;
	static int[] eenPerm;
	static boolean[] eenSelected;
	static int win, lose;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			
			win = 0; lose = 0;
			card = new int[19];
			kyu = new int[9]; // �Կ����� ī��
			een = new int[9]; // �ο����� ī��
			eenPerm = new int[9]; // �ο��� ī���� ������ ������� ����� �迭
			eenSelected = new boolean[9];
			
			for(int i=0; i<9; i++) {
				int n = sc.nextInt();
				card[n] = 1; // �Կ����� ī��� 1�� ǥ��
			}
			
			// �Կ��̿� �ο����� ī�� �迭�� �����.
			int cntk = 0, cnte = 0;
			for(int i=1; i<19; i++) {
				if(card[i]==1) {
					kyu[cntk++] = i;
				} else {
					een[cnte++] = i;
				}
			}
			
			// �ο����� ī��� ������ ��������� ����Լ� ȣ��.
			perm(0);
			
			System.out.println("#"+tc+" "+win+" "+lose);
		}
	}
	
	static void perm(int cnt) {
		if(cnt == 9) { // �ο����� ī��� ������ ��� ������ٸ�
			
			int totalKyu = 0, totalEen = 0;
			for(int i=0; i<9; i++) {
				if(kyu[i] > eenPerm[i]) { // �Կ����� ī�尡 ū ���
					totalKyu += (kyu[i]+eenPerm[i]);
				} else if(kyu[i] < eenPerm[i]) { // �ο����� ī�尡 ū ���
					totalEen += (kyu[i]+eenPerm[i]);
				}
			}
			
			if(totalKyu > totalEen) {
				win++;
			}else if(totalKyu < totalEen) {
				lose++;
			}
			
			return;
		}
		for(int i=0; i<9; i++) {
			if(eenSelected[i]) continue;
			eenSelected[i] = true;
			eenPerm[cnt] = een[i];
			perm(cnt+1);
			eenSelected[i] = false;
		}
	}

}
