package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2636치즈 {
	
	static int N, M;
	static int[][] board;
	static Queue<Point> queue1;
	static Queue<Point> queue2;
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		board = new int[N][M];
		queue1 = new LinkedList<>();
		
		for(int i=0; i<N; i++){		
			for(int j=0; j<M; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		// 가장 바깥쪽은 공기이므로 안심하고 0,0부터 공기 부분을 -1로 만들어주기
		bfs(0, 0); 
		
		int time = 0; // 치즈가 녹는데 걸리는 시간을 저장할 변수
		int cheeseNum = 0; // 마지막 치즈칸의 수를 저장할 변수
		
		while(true) {
			// 모든 좌표를 검사할 것인데
			for(int i=0; i<N; i++){		
				for(int j=0; j<M; j++) {
					if(board[i][j] == -1) { // 공기라면
						for(int d=0; d<4; d++) { // 공기의 사방에 
							int ni = i + di[d];
							int nj = j + dj[d];
							if(ni<0 || ni>=N || nj<0 || nj>=M) continue;
							if(board[ni][nj] == 1) { // 치즈가 있다면
								board[ni][nj] = 2; // 잠시 표시 -> -1로 하게되면 다음 탐색에 영향을 주게됨
								queue1.add(new Point(ni, nj));
								// 큐에 추가해둔다. => 탐색이후, -1로 만들고 크기도 활용할 예정임
							}
						}
					}
				}
			} // for end
			
			if(queue1.size()!=0) cheeseNum = queue1.size(); // 큐의 사이즈가 0이 아니라면,, 치즈가 있는 것
			else break; // 큐의 사이즈가 0이라면 치즈가 없는 것이니 탐색 그만하자
			
			while(!queue1.isEmpty()) { // 큐의 사이즈가 0이 아니라면, 큐에 들어있는 좌표들은 공기와 만난 치즈들
				Point n = queue1.poll(); // 꺼내서 -1로 만들건데.. 
				// 치즈가 녹으면서 치즈 속에 비어서 0으로 남아있던 부분도 공기에 닿는 일이 발생 가능함.
				bfs(n.i, n.j); // -1로 바꾸어주기 + 0에 대한 bfs 탐색을 진행
			}
			time++;
		}
		System.out.println(time);
		System.out.println(cheeseNum);
		
	}
	
	// 공기 부분을 모두 -1로 만들어주는 bfs 메소드
	static void bfs(int i, int j) {
		
		queue2 = new LinkedList<>();
		queue2.add(new Point(i, j));
		board[i][j] = -1;
		
		while(!queue2.isEmpty()) {
			Point n = queue2.poll();
			board[n.i][n.j] = -1;
			
			for(int d=0; d<4; d++) {
				int ni = n.i + di[d];
				int nj = n.j + dj[d];
				if(ni<0 || ni>=N || nj<0 || nj>=M) continue;
				if(board[ni][nj] == 0) {
					queue2.add(new Point(ni, nj));
					board[ni][nj] = -1;
				}
			}
		}
	}
	
	static class Point{
		int i, j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
}
