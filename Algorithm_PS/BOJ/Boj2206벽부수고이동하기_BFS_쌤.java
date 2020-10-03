package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2206���μ����̵��ϱ�_BFS_�� {
	static int N, M; // ��, ��
	static int[][] map;
	static int[][][] visit; // � ��ǥ i,j�� ���� �Ⱥμ���0, �μ���1 ���� "�Ÿ� ��Ͽ뵵"
	// visit �迭�� �ΰ� �����̳� �ٸ� ���� => �Ÿ� ��ϰ� ���ÿ� �湮���� ��� �뵵

	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j] = line[j]-'0';
			}
		}
		
		visit = new int[N][M][2]; // ���������κ��� �Ÿ��� ����� �迭
		for(int i=0; i<N; i++) { // �ʱ⿡�� ��� ĭ������ �Ÿ� �ִ�� ��Ƴ��� �� ������ ��Ÿ���� �����ؼ� ����������~~
			for(int j=0; j<M; j++) {
				for(int k=0; k<2; k++) {
					visit[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0, 0));
		visit[0][0][0] = 1; // ��������� �Ÿ� �ϴ� 1. ���⼭ +1 �ؼ� �Ÿ��� �־���.
		visit[0][0][1] = 1;
		
		while(!queue.isEmpty()) { // �湮 ���� ��ǥ�� �ִٸ�.
			Point now = queue.poll();
			
			for(int d=0; d<4; d++) {
				int ni = now.i + di[d];
				int nj = now.j + dj[d];
				
				if(!check(ni, nj)) continue;
				
				if(map[ni][nj]==0 && visit[ni][nj][now.wall] > visit[now.i][now.j][now.wall]+1) {
					// ��ĭ ni, nj�� ���� �ƴϰ�, ���� ��ĭ������ �Ÿ����� ���� now��� ���°� �� ���� ���(���� ���� �μ���Ե� �Ⱥμ��� �Ե�)
					visit[ni][nj][now.wall] = visit[now.i][now.j][now.wall]+1;
					queue.add(new Point(ni, nj, now.wall));
				}else if(map[ni][nj]==1 && now.wall==0) {
					// ��ĭ ni, nj�� ���϶��� ���� ���� ���� �μ����� ���� ���¿�����.
					visit[ni][nj][1] = visit[now.i][now.j][0] + 1;
					queue.add(new Point(ni, nj, 1));
				}
			}
		}
		// ���� �μ��� ���� ���� �ƴ� ����� �ִܰŸ��� ���ϰ� ��.
		int ans = Math.min(visit[N-1][M-1][0], visit[N-1][M-1][1]);
		System.out.println(ans==Integer.MAX_VALUE? -1: ans);
	}
	
	// �׳� ���� üũ ���� �������
	static boolean check(int i, int j) {
		if(i>=0 && i<N && j>=0 && j<M)
			return true;
		return false;
	}
	
	static class Point {
		int i, j, wall; // ���� �μ� Ƚ�� = 0 or 1

		Point(int i, int j, int wall) {
			this.i = i;
			this.j = j;
			this.wall = wall;
		}
	}
}