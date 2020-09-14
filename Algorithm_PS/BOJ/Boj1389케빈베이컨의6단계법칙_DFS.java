package BOJ;

import java.util.Scanner;

public class Boj1389케빈베이컨의6단계법칙_DFS {

	static int kbnum, kans, uans; // 케빈 베이컨 수를 셀 변수, 답 : 케빈베이컨 수, 유저의 번호
	static int N, M;
	static int[][] map;
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int m=0; m<M; m++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			map[v1][v2] = 1;
			map[v2][v1] = 1;
		}
		
		// 유저를 하나씩 선택해서 걔의 케빈 베이컨 수를 구한다.
		kans = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++) {
			kbnum = 0;
			dfs(i, 0); // 유저의 번호, 케빈 베이컨 수
			
			// 그 때 나온 베이컨 수들 중에 최소값을 구하고, 만약 베이컨 수가 같다면 유저의 수를 가장 작은애로 갱신해준다.
			if(kans > kbnum) {
				uans = i;
				kans = kbnum;
			}else if(kans == kbnum && uans > i) {
				uans = i;
			}
		}
		
		System.out.println(uans);
		
	}
	
	static void dfs(int v, int kbn) {
		visit[v] = true;
		
		kbnum += kbn;
		
		for(int i=1; i<=N; i++) {
			if(map[v][i]==1 && !visit[i]) {
				dfs(i, kbn+1);
			}
		}
		
		visit[v] = false; // 다른 유저(정점)이 dfs탐색을 진행 가능하도록!
	}
	
	
}
