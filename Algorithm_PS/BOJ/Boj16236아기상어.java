package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 아무리 고쳐도 지저분하다... 꼭 교수님 코드 따라하고 배우기!
public class Boj16236아기상어 {
	
	static int N, minDist, ans;
	static int sharki, sharkj, sharkSize, eat;
	static int movei, movej;
	static int[][] space;
	static boolean[][] visit;
	static Queue<Point> queue;
	
	static int[] di = {-1,1,0,0}; // 사방으로 이동하기 위한 델타 배열
	static int[] dj = {0,0,-1,1};
	
	static class Point{
		int i, j, dist;
		Point(int i, int j, int dist){
			this.i = i;
			this.j = j;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		space = new int[N][N];
		visit = new boolean[N][N];
		queue = new LinkedList<>();
		minDist = Integer.MAX_VALUE;
		eat = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				space[i][j] = sc.nextInt();
				if(space[i][j] == 9) { // 아기 상어
					sharki = i;
					sharkj = j;
					sharkSize = 2;
					space[i][j] = 0;
					queue.add(new Point(sharki, sharkj, 0));
					visit[i][j] = true;
				}
			}
		}
		
		while(true) {
			
			bfs();
			
			// 더이상 먹을 물고기가 없는 경우 나간다.
			if(minDist == Integer.MAX_VALUE) break;
			
			// 물고기가 있을 경우, 물고기 먹기
			ans += minDist;
			// 먹은 물고기 수가 상어의 크기와 같다면 상어의 크기를 키운다.
			if(++eat == sharkSize) {
				sharkSize++;
				eat = 0;
			}
			
			space[movei][movej] = 0; // 물고기 먹은 자리는 이제 빈칸이고,
			
			queue = new LinkedList<>(); // 그 자리에서 새롭게 bfs탐색을 할거야.
			queue.add(new Point(movei, movej, 0)); // 물고기 먹은 자리가 이제 상어의 자리야.
			visit = new boolean[N][N]; // 새로운 탐색이니까 visit도 초기화 해주어야지
			visit[movei][movej] = true; // 이제 상어가 있을 자리이니 방문 처리해주자
			// 새로운 탐색을 위해 변수들을 초기화해준다.
			minDist = Integer.MAX_VALUE;
			movei = -1; movej = N;
		}
		
		System.out.println(ans);
		
	}
	
	static void bfs() {
		
		while(!queue.isEmpty()) {
			
			Point n = queue.poll();
			
			if(space[n.i][n.j]!=0 && space[n.i][n.j] < sharkSize) { // 빈칸이 아닌, 먹을 수 있는 물고기가 있는 곳이면 그 자리를 기억할거야.
				if(n.dist == minDist && n.i <= movei) { // 거리가 같은데, 지금보다 더 위에 있는 물고기라면
					if(n.i == movei && n.j < movej) { // 같은 행에 위치하고 있는 물고기 중에서는 왼쪽에 있는 물고기를 먹어야지.
						movei = n.i;
						movej = n.j;
					}else if(n.i < movei) { // 더 위에 있다면, 더 위에 있는 물고기를 먹어야지.
						movei = n.i;
						movej = n.j;
					}
				}else if(n.dist < minDist) { // 거리가 더 짧으면, 이 물고기를 먹어야지.
					movei = n.i;
					movej = n.j;
					minDist = n.dist;
				}
			}
			
			for(int d=0; d<4; d++) {
				int ni = n.i + di[d];
				int nj = n.j + dj[d];
				if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
				// 상어와 같은 사이즈의 물고기가 있는 곳은 지나갈 수 있으므로 큐에 같이 추가. 
				// -> 이 물고기가 있는 경로를 통해서 더 짧은거리로 갈 수 있을 수도 있으니까.
				if(space[ni][nj]<=sharkSize && !visit[ni][nj]) {
					queue.add(new Point(ni, nj, n.dist+1));
					visit[ni][nj] = true;
				}
			}
		}
	}// bfs end
	
}
