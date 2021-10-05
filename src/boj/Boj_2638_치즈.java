package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2638_치즈 {

    static int N, M, cheese;
    static int[][] map;
    static boolean[][] visit;
    static int[][] didj = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    static class Point{
        int i, j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map =  new int[N][M];
        visit = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==1) cheese++;
            }
        }
        air(0, 0);
        int meltCnt = 0;
        int time = 0;
        while(meltCnt<cheese){
            // 치즈 발견 -> 2개 이상 공기와 인접시 녹인다.
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j]==1){
                        if(check(i, j)){
                            map[i][j]=7;
                        }
                    }
                }
            }
            // 녹인 치즈를 -1로 변경해주는 작업
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j]==7){
                        map[i][j]=-1;
                        air(i, j);
                        meltCnt++;
                    }
                }
            }
            time++;
        }
        System.out.println(time);
    }

    private static boolean check(int i, int j) {
        int air = 0;
        for(int d=0; d<4; d++){
            int ni = i + didj[d][0];
            int nj = j + didj[d][1];
            if(ni<0||ni>=N||nj<0||nj>=M) continue;
            if(map[ni][nj]==-1) air++;
        }
        if(air>=2) return true;
        return false;
    }

    private static void air(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));
        map[i][j]=-1;
        while(!q.isEmpty()){
            Point n = q.poll();
            for(int d=0; d<4; d++){
                int ni = n.i + didj[d][0];
                int nj = n.j + didj[d][1];
                if(ni<0||ni>=N||nj<0||nj>=M) continue;
                if(map[ni][nj]==0){
                    q.add(new Point(ni, nj));
                    map[ni][nj]=-1;
                }
            }
        }
    }

}