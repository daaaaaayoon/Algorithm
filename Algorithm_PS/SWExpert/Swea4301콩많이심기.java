package SWEA;

import java.util.Scanner;

public class Swea4301�ḹ�̽ɱ� {
	
	static int N, M, ans; // �� ��
	static int[][] area;
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			M = sc.nextInt(); // ��
			N = sc.nextInt(); // ��
			
			area = new int[N][M]; // ��
			
			bean();
			
			ans = 0;
			// �ɾ��� ���� ������ ����
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(area[i][j]==1) ans++;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void bean() {
		
		// �翡 ���� ���� �� �ִ����� ����.
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				boolean beanExist = false;
				// ������� �Ÿ� 2��ŭ ���� �ִ��� ����.
				for(int dir=0; dir<4; dir++) {
					int nexti = i + di[dir]*2; 
					int nextj = j + dj[dir]*2; 
					if(nexti<0 || nexti>=N || nextj<0 || nextj>=M) continue;
					// ���� �ִٸ�
					if(area[nexti][nextj]==1) { 
						beanExist = true; // ���� �ִٰ� ǥ��
						break;
					}
				}
				// ���� ���� �� �ִٸ� (��� �Ÿ� 2��ŭ ���� ���ٸ�)
				if(!beanExist) {
					area[i][j] = 1; // ���� ����
				}
			}
		}
	}
}
