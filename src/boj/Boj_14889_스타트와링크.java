package boj;

import java.util.Scanner;

public class Boj_14889_스타트와링크 {

    static int N, ans;
    static int[][] s;
    static boolean[] visit;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        s = new int[N+1][N+1];
        visit = new boolean[N+1];
        ans = Integer.MAX_VALUE;

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                s[i][j] = sc.nextInt();
            }
        }

        comb(1, 0);
        System.out.println(ans);

    }

    private static void comb(int start, int cnt) {

        if(cnt == N/2) {
            diff();
            return;
        }

        // visit 배열로 선택된 숫자인지 아닌지 판단 가능
        for(int i=start; i<=N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                comb(i + 1, cnt + 1);
                visit[i] = false;
            }
        }

    }

    private static void diff() {

        int teamStart = 0;
        int teamLink = 0;

        for(int i=1; i<=N; i++) {
            for(int j=i; j<=N; j++) {
                if(visit[i] && visit[j]) {
                    teamStart += (s[i][j] + s[j][i]);
                }else if(!visit[i] && !visit[j]) {
                    teamLink += (s[i][j] + s[j][i]);
                }
            }
        }

        // 능력치의 차이
        ans = Math.min(ans, Math.abs(teamStart-teamLink));
        if(ans == 0) {
            System.out.println(ans);
            System.exit(0);
        }
    }

}
