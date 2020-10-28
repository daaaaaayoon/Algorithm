public class Swea7733치즈도둑 {
	
	static int[][] cheese;
	static boolean[][] visit;
	static int max, N;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			N = sc.nextInt();
			cheese = new int[N][N];
			
			max=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					cheese[i][j] = sc.nextInt();
					if(max <= cheese[i][j]) max = cheese[i][j];
				}
			}
			
			int ans=0; // 덩어리의 개수, 정답
			while(true) {
				if(max == 0) break;
				visit = new boolean[N][N];
				int cnt=0; 
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(!visit[i][j] && cheese[i][j] >= max) {
							dfs(i, j);
							++cnt;
						}
					}
				}
				if(ans < cnt) ans = cnt;				
				max--;
			}
			System.out.println("#"+tc+" "+ans);
		}// tc end
	}// main end
	
	static void dfs(int i, int j) {
		visit[i][j] = true;
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
			if(!visit[ni][nj] && cheese[ni][nj] >= max) {
				dfs(ni, nj);
			}
		}
	}
}
