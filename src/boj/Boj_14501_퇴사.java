package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14501_퇴사 {

    static int N, ans;
    static int[][] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        s = new int[N+1][2];
        for(int n=1; n<=N; n++) {
            st = new StringTokenizer(br.readLine());
            s[n][0] = Integer.parseInt(st.nextToken());
            s[n][1] = Integer.parseInt(st.nextToken());
        }
        solve(0, 0);
        System.out.println(ans);
    }

    private static void solve(int day, int income) {

        ans = Math.max(income, ans);

        int availStart = (day!=0)? day + s[day][0] :1;
        for(int i=availStart; i<=N; i++) {
            if(s[i][0]+i<=N+1) {
                solve(i, income+s[i][1]);
            }
        }

    }

}
