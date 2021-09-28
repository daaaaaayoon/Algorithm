package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1238_파티_플로이드 {

    static int N, M, X;
    static int[][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        D = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i!=j){
                    D[i][j]=1000001;
                }
            }
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            D[start][end]=weight;
        }

        for(int k=1; k<=N; k++){ // 경유지
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(D[i][j]>D[i][k]+D[k][j]){
                        D[i][j]=D[i][k]+D[k][j];
                    }
                }
            }
        }

        int ans = -1;
        for(int i=1; i<=N; i++){
            ans = Math.max(ans, D[i][X]+D[X][i]);
        }
        System.out.println(ans);

    }

}
