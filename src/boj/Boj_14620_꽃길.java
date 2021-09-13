package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14620_꽃길 {

    static int N, ans;
    static int[][] map;
    static boolean[][] visit;
    static int[][] didj = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        ans = Integer.MAX_VALUE;
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);
        System.out.println(ans);
    }

    private static void solve(int cnt, int cost) {

        if(cnt == 3){
            ans = Math.min(ans, cost);
            return;
        }

        for(int i=1; i<N-1; i++){
            for(int j=1; j<N-1; j++){
                if(!visit[i][j] && check(i, j)){
                    int sum = seed(i, j, true);
                    solve(cnt+1, cost+sum);
                    seed(i, j, false);
                }
            }
        }

    }

    private static int seed(int i, int j, boolean flag) {
        int sum = 0;
        visit[i][j] = flag;
        for(int d=0; d<4; d++){
            int ni = i + didj[d][0];
            int nj = j + didj[d][1];
            if(ni<0 || nj<0 || ni>=N || nj>=N) continue;
            visit[ni][nj]=flag;
            sum+=map[ni][nj];
        }
        return sum+map[i][j];
    }

    private static boolean check(int i, int j) {
        for(int d=0; d<4; d++){
            int ni = i + didj[d][0];
            int nj = j + didj[d][1];
            if(ni<0 || nj<0 || ni>=N || nj>=N) return false;
            if(visit[ni][nj]) return false;
        }
        return true;
    }


}
