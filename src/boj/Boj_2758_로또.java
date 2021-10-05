package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2758_로또 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc=1; tc<=TC; tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            long[][] dp = new long[n+1][m+1];
            for(int i=0; i<=m; i++){
                dp[0][i]=1L;
            }
            for(int i=1; i<=n; i++){
                for(int j=1; j<=m; j++){
                    dp[i][j]=dp[i][j-1]+dp[i-1][j/2];
                }
            }
            System.out.println(dp[n][m]);
        }
    }

}
