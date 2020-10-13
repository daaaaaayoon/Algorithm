package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// �ƹ��� ���ĵ� �������ϴ�... �� ������ �ڵ� �����ϰ� ����!
public class Boj16236�Ʊ��� {
	
	static int N, minDist, ans;
	static int sharki, sharkj, sharkSize, eat;
	static int movei, movej;
	static int[][] space;
	static boolean[][] visit;
	static Queue<Point> queue;
	
	static int[] di = {-1,1,0,0}; // ������� �̵��ϱ� ���� ��Ÿ �迭
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
				if(space[i][j] == 9) { // �Ʊ� ���
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
			
			// ���̻� ���� ����Ⱑ ���� ��� ������.
			if(minDist == Integer.MAX_VALUE) break;
			
			// ����Ⱑ ���� ���, ����� �Ա�
			ans += minDist;
			// ���� ����� ���� ����� ũ��� ���ٸ� ����� ũ�⸦ Ű���.
			if(++eat == sharkSize) {
				sharkSize++;
				eat = 0;
			}
			
			space[movei][movej] = 0; // ����� ���� �ڸ��� ���� ��ĭ�̰�,
			
			queue = new LinkedList<>(); // �� �ڸ����� ���Ӱ� bfsŽ���� �Ұž�.
			queue.add(new Point(movei, movej, 0)); // ����� ���� �ڸ��� ���� ����� �ڸ���.
			visit = new boolean[N][N]; // ���ο� Ž���̴ϱ� visit�� �ʱ�ȭ ���־����
			visit[movei][movej] = true; // ���� �� ���� �ڸ��̴� �湮 ó��������
			// ���ο� Ž���� ���� �������� �ʱ�ȭ���ش�.
			minDist = Integer.MAX_VALUE;
			movei = -1; movej = N;
		}
		
		System.out.println(ans);
		
	}
	
	static void bfs() {
		
		while(!queue.isEmpty()) {
			
			Point n = queue.poll();
			
			if(space[n.i][n.j]!=0 && space[n.i][n.j] < sharkSize) { // ��ĭ�� �ƴ�, ���� �� �ִ� ����Ⱑ �ִ� ���̸� �� �ڸ��� ����Ұž�.
				if(n.dist == minDist && n.i <= movei) { // �Ÿ��� ������, ���ݺ��� �� ���� �ִ� �������
					if(n.i == movei && n.j < movej) { // ���� �࿡ ��ġ�ϰ� �ִ� ����� �߿����� ���ʿ� �ִ� ����⸦ �Ծ����.
						movei = n.i;
						movej = n.j;
					}else if(n.i < movei) { // �� ���� �ִٸ�, �� ���� �ִ� ����⸦ �Ծ����.
						movei = n.i;
						movej = n.j;
					}
				}else if(n.dist < minDist) { // �Ÿ��� �� ª����, �� ����⸦ �Ծ����.
					movei = n.i;
					movej = n.j;
					minDist = n.dist;
				}
			}
			
			for(int d=0; d<4; d++) {
				int ni = n.i + di[d];
				int nj = n.j + dj[d];
				if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
				// ���� ���� �������� ����Ⱑ �ִ� ���� ������ �� �����Ƿ� ť�� ���� �߰�. 
				// -> �� ����Ⱑ �ִ� ��θ� ���ؼ� �� ª���Ÿ��� �� �� ���� ���� �����ϱ�.
				if(space[ni][nj]<=sharkSize && !visit[ni][nj]) {
					queue.add(new Point(ni, nj, n.dist+1));
					visit[ni][nj] = true;
				}
			}
		}
	}// bfs end
	
}
