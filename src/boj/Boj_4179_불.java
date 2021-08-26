package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_4179_불 {

    static int R, C, ans;
    static char[][] map;
    static boolean[][] visit;
    static int[][] didj = {{0,-1}, {-1,0}, {0,1}, {1,0}};
    static Queue<Point> jihun, fire;

    static class Point {
        int i, j;
        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new boolean[R][C];
        jihun = new LinkedList<>();
        fire = new LinkedList<>();
        for(int i=0; i<R; i++) {
            String line = br.readLine();
            for(int j=0; j<C; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j]=='J') jihun.add(new Point(i, j));
                else if(map[i][j]=='F') fire.add(new Point(i, j));
            }
        }

        solve();
        System.out.println(ans==0?"IMPOSSIBLE":ans);
    }

    private static void solve() {

        int time = 0;
        while(!jihun.isEmpty()) {

            int jSize = jihun.size();
            for(int s=0; s<jSize; s++) {
                Point p = jihun.poll();
                if(map[p.i][p.j]!='F') {
                    for(int d=0; d<4; d++) {
                        int ni = p.i + didj[d][0];
                        int nj = p.j + didj[d][1];
                        if(ni<0 || nj<0 || ni>=R || nj>=C) {
                            ans = time+1;
                            return;
                        }
                        if(map[ni][nj]=='.'&&!visit[ni][nj]) {
                            jihun.add(new Point(ni, nj));
                            visit[ni][nj]=true;
                        }
                    }
                }
            }

            int fSize = fire.size();
            for(int s=0; s<fSize; s++) {
                Point p = fire.poll();
                for(int d=0; d<4; d++) {
                    int ni = p.i + didj[d][0];
                    int nj = p.j + didj[d][1];
                    if(ni<0 || nj<0 || ni>=R || nj>=C) continue;
                    if(map[ni][nj]=='.' || map[ni][nj]=='J') {
                        fire.add(new Point(ni, nj));
                        map[ni][nj]='F';
                    }
                }
            }

            time++;

        }

    }

}
