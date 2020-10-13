package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj16236�Ʊ���_������ {
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
		
		shark_w=2; // �Ʊ��� ó�� ũ�� 2
		while(true) { // ���� �� �ִ� ���̸� �� ���� ������ ��� �ݺ���. BFS ��� ��ġ���� �����ϴ� �ʺ�켱 Ž��
			visit = new boolean[N][N];
			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(shark_i, shark_j));
			visit[shark_i][shark_j] = true;
			
			int feedi = N, feedj=N;
			int dist=0; // �Ʊ� ���κ����� �Ÿ��� ����� ���� 
			boolean isEat = false; // �� ��� ��ġ���� Ž���� �����Ѵ�. ���� ��� �����ִ°� �� ������ �������� ������? �׸�..
			
			while(!queue.isEmpty()) {
				int qSize = queue.size(); // ���� ť�� �ִ� ��ǥ�� ���κ��� �Ÿ��� �� ���� ��ǥ����
				
				for(int i=0; i<qSize; i++) { // �ϴ� ��ǥ�� �� �߰��Ǵ��� ������ �����Ÿ� ��ǥ�鸸 ���� ���� ����.
					Point now = queue.poll();
					
					for(int d=0; d<4; d++) {
						int ni = now.i + di[d];
						int nj = now.j + dj[d];
						
						// ���̸� ã�� ���
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
							// ���̴� �ƴ����� ������ �� �ִ� ��ǥ���� �ϴ� ť�� ��ƺ���. ���� �Ȱ����� ��.(���� ã������ �Ȱ�����)
							visit[ni][nj] = true;
							queue.add(new Point(ni,nj));
						}
					}
				}
				dist++;
				if(feedi!=N && feedj!=N) { // ���� for ���鼭 ���� ã������ ?! ť�� ��ǥ ���Ҿ �� �Ⱥ�.
					map[shark_i][shark_j] = 0; // �� ����.
					shark_i = feedi; // ���ο� ���� ��ġ�� �� ����.
					shark_j = feedj;
					shark_eat++; // ���� �Ծ���.
					if(shark_eat == shark_w) {
						shark_w++;
						shark_eat=0;
					}
					ans += dist; // �� �������� �̵��� �Ÿ� ������Ű��.
					isEat= true;
					break;
				}
			} // end BFS
			if(!isEat) { // �ʺ�켱 Ž���� �ߴµ�.. �� �� �� �ִ� ���� ���̰� ������..�ϰ͵� ������..�׸�����..
				break;
			}
		}// end while(true)
		System.out.println(ans);
	}
}