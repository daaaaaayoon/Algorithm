package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_10026_적록색약_BFS {

    static int N;
    static char[][] map;
    static boolean[][] visit;
    static int[][] didj = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    static Queue<Point> queue;

    static class Point {
        int i, j;
        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visit = new boolean[N][N];

        for(int i=0; i<N; i++) {
            map[i]=br.readLine().toCharArray();
        }

        queue = new LinkedList<>();
        for(int n=0; n<2; n++) {

            int cnt = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visit[i][j]) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append(" ");

            if(n==1) break;
            changeMap();
            visit = new boolean[N][N];

        }

        System.out.println(sb.toString());

    }

    private static void changeMap() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]=='R') map[i][j] ='G';
            }
        }
    }

    private static void bfs(int i, int j) {

        queue.add(new Point(i, j));
        visit[i][j] = true;

        while(!queue.isEmpty()) {

            Point p = queue.poll();

            for(int d=0; d<4; d++) {
                int ni = p.i + didj[d][0];
                int nj = p.j + didj[d][1];
                if(ni<0 || nj<0 || ni>=N || nj>=N) continue;
                if(!visit[ni][nj] && map[p.i][p.j]==map[ni][nj]) {
                    queue.add(new Point(ni, nj));
                    visit[ni][nj] = true;
                }
            }

        }


    }

}
