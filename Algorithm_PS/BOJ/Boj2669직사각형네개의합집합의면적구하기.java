package BOJ;

import java.util.Scanner;

public class Boj2669���簢���װ����������Ǹ������ϱ� {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int[101][101];
		
		int ans = 0;
		for(int r=0; r<4; r++) { // ���簢�� �װ��� ���� �Է� �ޱ�
			int lx = sc.nextInt();
			int ly = sc.nextInt();
			int rx = sc.nextInt();
			int ry = sc.nextInt();
			
			for(int i=lx; i<rx; i++) {
				for(int j=ly; j<ry; j++) {
					if(map[i][j]==0) {
						ans++;
						map[i][j] = 1;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
