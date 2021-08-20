package boj;

import java.util.Scanner;

public class Boj_18868_멀티버스1 {
	
	static int M, N, ans;
	static int[][] space;
	static int[] selectSpace;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		ans = 0;
		space = new int[M][N];
		selectSpace = new int[2];
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				space[i][j] = sc.nextInt();
			}
		}
		
		comb(0, 0);
		System.out.println(ans);
	}
	
	static void comb(int cnt, int start) {
		
		if(cnt == 2) {
			
			int one = selectSpace[0];
			int other = selectSpace[1];
			
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					if(!((space[one][i]<space[one][j] && space[other][i]<space[other][j])
						|| (space[one][i]==space[one][j] && space[other][i]==space[other][j])
						|| (space[one][i]>space[one][j] && space[other][i]>space[other][j])
						)) return;
				}
			}
			ans++;
			return;
		}
		
		for(int i=start; i<M; i++) {
			selectSpace[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
}
