package BOJ;

import java.util.Scanner;

// DP 문제였어 ?!?!?!?!?!?!
// mCn을 조합의 식을 이용해서 풀려고 함 -> factorial과 메모이제이션을 사용했는데 범위를 넘어가는 일이 발생.
// 범위를 넘어가서 큰 숫자의 팩토리얼을 만들려고 했을 때, 숫자를 표현하지 못해서 정확한 답이 나오지 못함.
public class Boj1010다리놓기 {
	
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
