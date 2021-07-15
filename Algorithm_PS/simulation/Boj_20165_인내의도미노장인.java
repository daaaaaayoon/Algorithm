package algo_202107.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_20165_인내의도미노장인 {

    static int N, M, R;
    static int attackCnt;
    static int[][] map;
    static boolean[][] flag;
    static int[][] didj = {{0,1}, {0,-1}, {1,0}, {-1,0}}; // 동서남북

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        flag = new boolean[N+1][M+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r=0; r<R; r++) {

            // 공격
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            switch(st.nextToken()) {
                case "E":
                    push(x, y, 0);
                    break;
                case "W":
                    push(x, y, 1);
                    break;
                case "S":
                    push(x, y, 2);
                    break;
                case "N":
                    push(x, y, 3);
                    break;
            }

            // 수비
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            flag[x][y] = false;

        }

        System.out.println(attackCnt);
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                System.out.print(flag[i][j]?"F ":"S ");
            }
            System.out.println();
        }

    }

    private static void push(int x, int y, int dir) {

        flag[x][y] = true;
        attackCnt++;

        int len = map[x][y];

        for(int i=1; i<len; i++) {
            int ni = x + didj[dir][0] * i;
            int nj = y + didj[dir][1] * i;
            if (ni < 1 || ni >= N+1 || nj < 1 || nj >= M+1 || flag[ni][nj]) continue;
            push(ni, nj, dir);
        }

    }

}
