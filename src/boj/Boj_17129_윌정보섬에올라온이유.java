package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17129_윌정보섬에올라온이유 {

    static int N, M, ans;
    static char[][] map;
    static int[][] didj = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    static class Point{
        int i, j;
        Point(int i, int j){
            this.i=i;
            this.j=j;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0; i<N; i++){
            map[i]=br.readLine().toCharArray();
        }
        bfs();
        System.out.println(ans==0?"NIE":"TAK\n"+ans);

    }

    private static void bfs() {

        Queue<Point> queue = new LinkedList<>();

        // 시작점을 큐에 넣는다
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]=='2'){
                    queue.add(new Point(i, j));
                    map[i][j]='1';
                }
            }
        }

        // 너비우선탐색 시작
        int time = 0;
        while(!queue.isEmpty()){

            int qSize = queue.size();
            for(int s=0; s<qSize; s++){
                Point p = queue.poll();
                for(int d=0; d<4; d++){
                    int ni = p.i + didj[d][0];
                    int nj = p.j + didj[d][1];
                    if(ni<0||ni>=N||nj<0||nj>=M||map[ni][nj]=='1') continue;
                    if(map[ni][nj]=='3'||map[ni][nj]=='4'||map[ni][nj]=='5'){
                        ans = time+1;
                        return;
                    }
                    queue.add(new Point(ni, nj));
                    map[ni][nj]='1';
                }
            }
            time++;

        }


    }

}
