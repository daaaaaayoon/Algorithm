package swea_202107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Swea_2805_농작물수확하기 {

    static int N, ans;
    static int[][] map;
    static boolean[][] visit;
    static Queue<Point> queue;
    static int[][] didj = {{-1,0}, {1,0}, {0,1}, {0,-1}};

    static class Point {
        int i, j;
        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++) {

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visit = new boolean[N][N];
            queue = new LinkedList<>();
            ans = 0;

            for(int i=0; i<N; i++) {
                String line = br.readLine();
                for(int j=0; j<N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }

            visit[N/2][N/2] = true;
            queue.add(new Point(N/2, N/2));
            bfs();

            System.out.println("#"+tc+" "+ans);
        }

    }

    private static void bfs() {

        int count = 0;
        while(!queue.isEmpty()) {

            int qSize = queue.size();
            for(int s=0; s<qSize; s++) {
                Point p = queue.poll();
                ans += map[p.i][p.j];

                for(int d=0; d<4; d++) {
                    int ni = p.i + didj[d][0];
                    int nj = p.j + didj[d][1];
                    if(ni<0 || nj<0 || ni>=N || nj>=N) continue;
                    if(!visit[ni][nj]) {
                        visit[ni][nj] = true;
                        queue.add(new Point(ni, nj));
                    }
                }
            }
            if(count++ == N/2) return;

        }

    }

}
