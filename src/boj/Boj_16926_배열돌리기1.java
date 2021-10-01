package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16926_배열돌리기1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] didj = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int r=0; r<R; r++){
            for(int cnt=0; cnt<Math.min(N,M)/2; cnt++){
                int start = map[cnt][cnt];
                int x = cnt;
                int y = cnt;
                int d=0;
                while(d<4){
                    int nx = x + didj[d][0];
                    int ny = y + didj[d][1];
                    if(nx<cnt||nx>=N-cnt||ny<cnt||ny>=M-cnt) {
                        d++;
                        continue;
                    }
                    map[x][y]=map[nx][ny];
                    x = nx; y = ny;
                }
                map[cnt+1][cnt]=start;
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

}
