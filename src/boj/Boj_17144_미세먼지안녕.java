package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17144_미세먼지안녕 {

    static int R, C, T;
    static int[][] map, temp;
    static int[][] didj = {{-1,0},{0,-1},{1,0},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        // map 입력
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                map[r][c]=Integer.parseInt(st.nextToken());
            }
        }
        for(int t=1; t<=T; t++){

            // 미세먼지 확산
            temp = new int[R][C];
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(map[i][j]==-1) {
                        temp[i][j]=-1;
                        continue;
                    }
                    int count = 0;
                    for(int d=0; d<4; d++){
                        int ni = i + didj[d][0];
                        int nj = j + didj[d][1];
                        if(ni<0||ni>=R||nj<0||nj>=C||map[ni][nj]==-1) continue;
                        count++;
                        temp[ni][nj]+=(map[i][j]/5);
                    }
                    temp[i][j]+=map[i][j]-(map[i][j]/5)*count;
                }
            }
            map = temp;

            // 공기 청정기 작동
            boolean top = true;
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(map[i][j]==-1 && top) {
                        top(i, j);
                        top = false;
                    }else if(map[i][j]==-1 && !top){
                        bottom(i, j);
                    }
                }
            }

        }
        System.out.println(count());

    }

    private static void print() {
        System.out.println();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int count() {
        int count = 0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                count+=map[i][j];
            }
        }
        return count+2;
    }

    private static void bottom(int i, int j) {
        // 시계 방향
        for(int r=i; r<R-1; r++){
            map[r][0]=map[r+1][0];
        }
        for(int c=0; c<C-1; c++){
            map[R-1][c]=map[R-1][c+1];
        }
        for(int r=R-1; r>i; r--){
            map[r][C-1]=map[r-1][C-1];
        }
        for(int c=C-1; c>1; c--){
            map[i][c]=map[i][c-1];
        }
        map[i][j]=-1;
        map[i][j+1]=0;
    }

    private static void top(int i, int j) {
        // 반시계 방향
        for(int r=i-1; r>0; r--){
            map[r][0]=map[r-1][0];
        }
        for(int c=0; c<C-1; c++){
            map[0][c]=map[0][c+1];
        }
        for(int r=0; r<i; r++){
            map[r][C-1]=map[r+1][C-1];
        }
        for(int c=C-1; c>1; c--){
            map[i][c]=map[i][c-1];
        }
        map[i][j]=-1;
        map[i][j+1]=0;
    }

}
