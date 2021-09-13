package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14500_테트로미노 {

    static int N, M, ans;
    static int[][] map;
    static boolean[][] visit;
    static int[][] didj = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        ans = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visit[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                for(int d=0; d<4; d++){
                    mountain(i, j, d);
                }
                visit[i][j] = false;
            }
        }
        System.out.println(ans);
    }

    private static void mountain(int i, int j, int except) {
        int sum = 0;
        int count = 0;
        for(int d=0; d<4; d++){
            int ni = i + didj[d][0];
            int nj = j + didj[d][1];
            if(ni<0 || nj<0 || ni>=N || nj>=M || d == except) continue;
            sum += map[ni][nj];
            count++;
        }
        if(count == 3) {
            ans = Math.max(ans, sum+map[i][j]);
        }
    }

    private static void dfs(int i, int j, int cnt, int sum) {


        if(cnt == 4){
            ans = Math.max(ans, sum);
            return;
        }
        for(int d=0; d<4; d++){
            int ni = i + didj[d][0];
            int nj = j + didj[d][1];
            if(ni<0 || nj<0 || ni>=N || nj>=M) continue;
            if(!visit[ni][nj]){
                visit[ni][nj] = true;
                dfs(ni, nj, cnt+1, sum+map[ni][nj]);
                visit[ni][nj] = false;
            }
        }

    }

}
