package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_16236_아기상어_other {
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	static int N;
	static int[][] map;
	static boolean[][] visit;
	
	static class Point{
		int i,j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
	static int shark_i, shark_j, shark_w, shark_eat;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				
				if(map[i][j]==9) { // �Ʊ�� �Էµȴٸ�,
					shark_i = i;
					shark_j = j;
				}
			}
		}
		
		shark_w=2;
		while(true) {
			visit = new boolean[N][N];
			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(shark_i, shark_j));
			visit[shark_i][shark_j] = true;
			
			int feedi = N, feedj=N;
			int dist=0;
			boolean isEat = false;
			while(!queue.isEmpty()) {
				int qSize = queue.size();
				
				for(int i=0; i<qSize; i++) {
					Point now = queue.poll();
					
					for(int d=0; d<4; d++) {
						int ni = now.i + di[d];
						int nj = now.j + dj[d];
						
						if(ni>=0 && ni<N && nj>=0 && nj<N
								&& (map[ni][nj]<shark_w && map[ni][nj]>0) && !visit[ni][nj]) {
							visit[ni][nj] = true;
							if(feedi>ni) {
								feedi = ni;
								feedj = nj;
							}else if(feedi == ni && feedj > nj) {
								feedj = nj;
							}
						}else if(ni>=0 && ni<N && nj>=0 && nj<N && 
								(map[ni][nj]==0 || map[ni][nj]==shark_w) && !visit[ni][nj]) {
							visit[ni][nj] = true;
							queue.add(new Point(ni,nj));
						}
					}
				}
				dist++;
				if(feedi!=N && feedj!=N) {
					map[shark_i][shark_j] = 0;
					shark_i = feedi;
					shark_j = feedj;
					shark_eat++;
					if(shark_eat == shark_w) {
						shark_w++;
						shark_eat=0;
					}
					ans += dist;
					isEat= true;
					break;
				}
			} // end BFS
			if(!isEat) {
				break;
			}
		}// end while(true)
		System.out.println(ans);
	}
}