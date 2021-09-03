package boj;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.LinkedList;
        import java.util.Queue;

public class Boj_11559_PuyoPuyo {

    static int N, M, ans;
    static char[][] map;
    static boolean[][] visit;
    static int[][] didj = {{-1,0}, {0,-1}, {0,1}, {1,0}};

    static class Point{
        int i, j;
        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 12; M = 6;
        map = new char[N][M];
        visit = new boolean[N][M];
        for(int i=0; i<N; i++) {
            map[i]=br.readLine().toCharArray();
        }

        while(true) {

            // 4개 이상 같은 색상 터치기
            boolean bomb = false;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    //  &&!visit[i][j]
                    if(map[i][j]!='.' &&!visit[i][j]) {
                        if(check(i, j)) {
                            bomb = true;
                            remove(i, j);
                        }
                    }
                }
            }

            // 연쇄
            if(!bomb) break;
            ans++;

            // 중력
            int pointer = 0;
            for(int j=0; j<M; j++) {
                boolean first = true;
                for(int i=N-1; i>=0; i--) {
                    if(first && map[i][j]=='.') {
                        pointer = i;
                        first = false;
                    }
                    if(!first && map[i][j]!='.') {
                        map[pointer][j] = map[i][j];
                        map[i][j]='.';
                        pointer--;
                    }
                }
            }

        }

        System.out.println(ans);

    }

    private static void remove(int i, int j) {

        Queue<Point> queue = new LinkedList<>();
        visit = new boolean[N][M];
        queue.add(new Point(i, j));
        visit[i][j] = true;

        while(!queue.isEmpty()) {
            Point n = queue.poll();
            char ch = map[n.i][n.j];
            map[n.i][n.j] = '.';
            for(int d=0; d<4; d++) {
                int ni = n.i + didj[d][0];
                int nj = n.j + didj[d][1];
                if(ni<0 || nj<0 || ni>=N || nj>=M || visit[ni][nj]) continue;
                if(ch==map[ni][nj]) {
                    queue.add(new Point(ni, nj));
                    visit[ni][nj] = true;
                }
            }
        }

    }

    private static boolean check(int i, int j) {

        Queue<Point> queue = new LinkedList<>();
        visit = new boolean[N][M];
        queue.add(new Point(i, j));
        visit[i][j] = true;

        int same = 0;
        while(!queue.isEmpty()) {
            Point n = queue.poll();
            same++;
            if(same>3) return true;
            for(int d=0; d<4; d++) {
                int ni = n.i + didj[d][0];
                int nj = n.j + didj[d][1];
                if(ni<0 || nj<0 || ni>=N || nj>=M || visit[ni][nj]) continue;
                if(map[n.i][n.j]==map[ni][nj]) {
                    queue.add(new Point(ni, nj));
                    visit[ni][nj] = true;
                }
            }
        }
        return false;
    }

}

