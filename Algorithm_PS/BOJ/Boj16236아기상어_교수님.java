package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj16236아기상어_교수님 {
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
				
				if(map[i][j]==9) { // 아기상어가 입력된다면,
					shark_i = i;
					shark_j = j;
				}
			}
		}
		
		shark_w=2; // 아기상어 처음 크기 2
		while(true) { // 먹을 수 있는 먹이를 다 먹을 때까지 계속 반복함. BFS 상어 위치에서 시작하는 너비우선 탐색
			visit = new boolean[N][N];
			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(shark_i, shark_j));
			visit[shark_i][shark_j] = true;
			
			int feedi = N, feedj=N;
			int dist=0; // 아기 상어로부터의 거리를 기록할 변수 
			boolean isEat = false; // 자 상어 위치에서 탐색을 시작한다. 만약 모든 갈수있는곳 다 가봐도 먹이한테 못가면? 그만..
			
			while(!queue.isEmpty()) {
				int qSize = queue.size(); // 현재 큐에 있는 좌표는 상어로부터 거리가 다 같은 좌표들임
				
				for(int i=0; i<qSize; i++) { // 일단 좌표가 더 추가되더라도 기존에 같은거리 좌표들만 먼저 보고 결정.
					Point now = queue.poll();
					
					for(int d=0; d<4; d++) {
						int ni = now.i + di[d];
						int nj = now.j + dj[d];
						
						// 먹이를 찾은 경우
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
							// 먹이는 아니지만 지나갈 수 있는 좌표이지 일단 큐에 담아보자. 갈지 안갈지는 모름.(먹이 찾았으면 안가긋지)
							visit[ni][nj] = true;
							queue.add(new Point(ni,nj));
						}
					}
				}
				dist++;
				if(feedi!=N && feedj!=N) { // 위에 for 돌면서 먹이 찾았으면 ?! 큐에 좌표 남았어도 더 안봄.
					map[shark_i][shark_j] = 0; // 상어가 떠남.
					shark_i = feedi; // 새로운 먹이 위치로 상어가 갔음.
					shark_j = feedj;
					shark_eat++; // 먹이 먹었음.
					if(shark_eat == shark_w) {
						shark_w++;
						shark_eat=0;
					}
					ans += dist; // 상어가 먹이한테 이동한 거리 누적시키기.
					isEat= true;
					break;
				}
			} // end BFS
			if(!isEat) { // 너비우선 탐색을 했는데.. 상어가 갈 수 있는 곳에 먹이가 없었네..암것도 못먹음..그만하자..
				break;
			}
		}// end while(true)
		System.out.println(ans);
	}
}