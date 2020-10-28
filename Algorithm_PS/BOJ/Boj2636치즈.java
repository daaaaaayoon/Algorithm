package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2636ġ�� {
	
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
		
		// ���� �ٱ����� �����̹Ƿ� �Ƚ��ϰ� 0,0���� ���� �κ��� -1�� ������ֱ�
		bfs(0, 0); 
		
		int time = 0; // ġ� ��µ� �ɸ��� �ð��� ������ ����
		int cheeseNum = 0; // ������ ġ��ĭ�� ���� ������ ����
		
		while(true) {
			// ��� ��ǥ�� �˻��� ���ε�
			for(int i=0; i<N; i++){		
				for(int j=0; j<M; j++) {
					if(board[i][j] == -1) { // ������
						for(int d=0; d<4; d++) { // ������ ��濡 
							int ni = i + di[d];
							int nj = j + dj[d];
							if(ni<0 || ni>=N || nj<0 || nj>=M) continue;
							if(board[ni][nj] == 1) { // ġ� �ִٸ�
								board[ni][nj] = 2; // ��� ǥ�� -> -1�� �ϰԵǸ� ���� Ž���� ������ �ְԵ�
								queue1.add(new Point(ni, nj));
								// ť�� �߰��صд�. => Ž������, -1�� ����� ũ�⵵ Ȱ���� ������
							}
						}
					}
				}
			} // for end
			
			if(queue1.size()!=0) cheeseNum = queue1.size(); // ť�� ����� 0�� �ƴ϶��,, ġ� �ִ� ��
			else break; // ť�� ����� 0�̶�� ġ� ���� ���̴� Ž�� �׸�����
			
			while(!queue1.isEmpty()) { // ť�� ����� 0�� �ƴ϶��, ť�� ����ִ� ��ǥ���� ����� ���� ġ���
				Point n = queue1.poll(); // ������ -1�� ����ǵ�.. 
				// ġ� �����鼭 ġ�� �ӿ� �� 0���� �����ִ� �κе� ���⿡ ��� ���� �߻� ������.
				bfs(n.i, n.j); // -1�� �ٲپ��ֱ� + 0�� ���� bfs Ž���� ����
			}
			time++;
		}
		System.out.println(time);
		System.out.println(cheeseNum);
		
	}
	
	// ���� �κ��� ��� -1�� ������ִ� bfs �޼ҵ�
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
