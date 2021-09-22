package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17484_진우의달여행Small {

    static int N, M, ans;
    static int[][] map;
    static int[][] didj = {{1,-1}, {1,0}, {1,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int j=0; j<M; j++){
            dfs(0, j, 3, map[0][j]);
        }
        System.out.println(ans);
    }

    static void dfs(int i, int j, int dir, int fuel){

        if(i==N-1){
            ans = Math.min(ans, fuel);
            return;
        }
        for(int d=0; d<3; d++){
            int ni = i + didj[d][0];
            int nj = j + didj[d][1];
            if(ni<0||ni>=N||nj<0||nj>=M || dir==d) continue;
            dfs(ni, nj, d, fuel+map[ni][nj]);
        }

    }

}
