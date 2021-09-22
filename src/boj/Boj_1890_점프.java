package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1890_점프 {

    static int N;
    static int[][] map;
    static long[][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        D = new long[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        D[0][0]=1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==0) continue;
                int x = i + map[i][j];
                if(x<N){
                    D[x][j]+=D[i][j];
                }
                int y = j + map[i][j];
                if(y<N){
                    D[i][y]+=D[i][j];
                }
            }
        }
        System.out.println(D[N-1][N-1]);
    }

}
