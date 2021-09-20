package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1937_욕심쟁이판다 {

    static int N;
    static int[][] map, D;
    static int[][] didj = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        D = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        // 모든 지점에서 출발하여 dfs
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                dfs(i, j);
            }
        }

        int ans=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                ans=Math.max(D[i][j], ans);
            }
        }
        System.out.println(ans==0?1:ans); // N이 1인 경우를 위해
    }

    private static void dfs(int i, int j) {

        for(int d=0; d<4; d++){
            int ni = i + didj[d][0];
            int nj = j + didj[d][1];
            if(ni<0||ni>=N||nj<0||nj>=N) continue;
            if(map[ni][nj]>map[i][j]){
                if(D[ni][nj]!=0){
                    D[i][j]=Math.max(D[i][j], D[ni][nj]+1);
                }else{
                    dfs(ni, nj);
                    D[i][j]=Math.max(D[i][j], D[ni][nj]+1);
                }
            }else{
                D[i][j]=Math.max(D[i][j], 1);
            }
        }

    }

}
