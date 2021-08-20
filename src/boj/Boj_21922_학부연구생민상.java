package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_21922_학부연구생민상 {

    static int N, M;
    static int[][] lab;
    static boolean[][] available;
    static int[][] didj = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static ArrayList<Ac> acs;
    static class Ac {
        int i, j;
        Ac(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];
        available = new boolean[N][M];
        acs = new ArrayList<>();

        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++) {
                lab[n][m] = Integer.parseInt(st.nextToken());
                if(lab[n][m] == 9) {
                    available[n][m] = true;
                    acs.add(new Ac(n, m));
                }
            }
        }

        // 연구실에 에어컨이 없다면,
        if(acs.size() == 0) {
            System.out.println(0);
            return;
        }

        // 연구실에 에어컨이 있다면,
        for(int a=0; a<acs.size(); a++) {
            Ac ac = acs.get(a);
            // 에어컨에서 사방으로 바람 보내기
            for(int d=0; d<4; d++) {
                blow(ac.i, ac.j, d);
            }
        }

        // 앉을 수 있는 자리 구하기
        int ans = 0;
        for(int n=0; n<N; n++) {
            for(int m=0; m<M; m++) {
                if(available[n][m]) ans++;
            }
        }
        System.out.println(ans);

    }

    private static void blow(int i, int j, int d) {

        int ni = i + didj[d][0];
        int nj = j + didj[d][1];
        if(ni<0 || ni>=N || nj<0 || nj>=M) return;

        available[ni][nj] = true;

        // 만난 물건이 lab[ni][nj]인 경우
        switch (lab[ni][nj]) {
            case 0: // 방향 d가 무엇이든 그냥 지나가기
                blow(ni, nj, d);
                break;
            case 1: // 방향 d가 1,3이라면 끝내기 0,2라면 계속 가기
                if(d==0 || d==2) blow(ni, nj, d);
                break;
            case 2: // 방향 d가 0,2라면 끝내기, 1,3이라면 계속 가기
                if(d==1 || d==3) blow(ni, nj, d);
                break;
            case 3:
                // d가 0이라면 -> 1로 변경
                if(d==0) blow(ni, nj, 1);
                // d가 1이라면 -> 0로 변경
                if(d==1) blow(ni, nj, 0);
                // d가 3이라면 -> 2로 변경
                if(d==3) blow(ni, nj, 2);
                // d가 2라면 -> 3로 변경
                if(d==2) blow(ni, nj, 3);
                break;
            case 4:
                // d가 0이라면 -> 3으로 변경
                if(d==0) blow(ni, nj, 3);
                // d가 3이라면 -> 0으로 변경
                if(d==3) blow(ni, nj, 0);
                // d가 1이라면 -> 2로 변경
                if(d==1) blow(ni, nj, 2);
                // d가 2라면 -> 1로 변경
                if(d==2) blow(ni, nj, 1);
                break;
        }

    }

}
