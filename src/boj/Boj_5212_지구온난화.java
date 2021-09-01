package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_5212_지구온난화 {

    static int R, C, si, sj, ei, ej;
    static char[][] map;
    static int[][] didj = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for(int i=0; i<R; i++) {
            map[i]=br.readLine().toCharArray();
        }

        after();
        getIndex();
        for(int i=si; i<=ei; i++) {
            for(int j=sj; j<=ej; j++) {
                System.out.print(map[i][j]=='S'?'.':map[i][j]);
            }
            System.out.println();
        }

    }

    private static void getIndex() {

        si=100; sj=100;
        ei=0; ej=0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]=='X'){
                    si=Math.min(si, i);
                    sj=Math.min(sj, j);
                    ei=Math.max(ei, i);
                    ej=Math.max(ej, j);
                }
            }
        }

    }

    private static void after() {

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j]=='X') { // 섬
                    // 3~4면이 바다인지 확인
                    int cnt=0;
                    for(int d=0; d<4; d++) {
                        int ni = i + didj[d][0];
                        int nj = j + didj[d][1];
                        if(ni<0 || nj<0 || ni>=R || nj>=C || map[ni][nj]=='.') cnt++;
                    }
                    if(cnt>=3) map[i][j]='S';
                }
            }
        }

    }

}
