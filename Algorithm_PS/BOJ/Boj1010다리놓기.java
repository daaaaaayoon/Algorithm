package BOJ;

import java.util.Scanner;

// DP �������� ?!?!?!?!?!?!
// mCn�� ������ ���� �̿��ؼ� Ǯ���� �� -> factorial�� �޸������̼��� ����ߴµ� ������ �Ѿ�� ���� �߻�.
// ������ �Ѿ�� ū ������ ���丮���� ������� ���� ��, ���ڸ� ǥ������ ���ؼ� ��Ȯ�� ���� ������ ����.
public class Boj1010�ٸ����� {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			int N = sc.nextInt(); // K
			int M = sc.nextInt(); // N
			
			// mCn
			int[][] D = new int[M+1][N+1];
			for(int i=0; i<=M; i++) {
				for(int j=0; j<=((i<=N)?i:N); j++) {
					if(j==0 || i==j) {
						D[i][j] = 1;
					}else {
						D[i][j] = D[i-1][j-1] + D[i-1][j];
					}
				}
			}
			
			System.out.println(D[M][N]);
		}
	}
}
