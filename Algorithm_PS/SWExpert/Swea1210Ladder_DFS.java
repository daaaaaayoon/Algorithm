package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1210Ladder_DFS {
	
	static int si, sj, ans;
	static boolean found;
	static int[][] ladder;
	
	static int[] di = {0,0,-1}; // �� �� ��
	static int[] dj = {-1,1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int TC = 10; // �׽�Ʈ���̽��� ����
		for(int tc=1; tc<=TC; tc++) {
			
			int t = Integer.parseInt(br.readLine()); // �׽�Ʈ���̽� �Է�
			
			ladder = new int[100][100];
			
			// ladder �迭 �Է¹ޱ�
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if(ladder[i][j]==2) { // ���� ��ġ ����
						si = i; sj = j;
					}
				}
			}
			
			found = false;
			dfs(si, sj); // ������ġ���� dfsŽ�� ����
			
			System.out.println("#"+t+" "+ans);
		}
	}
	
	static void dfs(int i, int j) {
		
		ladder[i][j] = 9; // �湮 ǥ�� 
		
		if(i == 0) {
			ans = j; // 0�࿡ �������� ���� ���� ��ǥ ����
			found = true;
			return;
		}
		
		for(int d=0; d<3; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(0<=ni && ni<100 && 0<=nj && nj<100 && ladder[ni][nj]==1 && !found) {
				dfs(ni, nj);
			}
		}
		
	}
	
	
}
