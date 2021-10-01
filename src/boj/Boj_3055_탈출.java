package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_3055_탈출 {

    static int R, C, ans;
    static char[][] map;
    static Queue<Point> wQueue;
    static Queue<Point> sQueue;
    static boolean[][] wVisit;
    static boolean[][] sVisit;
    static int[][] didj = {{-1,0}, {0,-1}, {1,0}, {0,1}};

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
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        wQueue = new LinkedList<>();
        sQueue = new LinkedList<>();
        wVisit = new boolean[R][C];
        sVisit = new boolean[R][C];
        for(int i=0; i<R; i++){
            String line = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j]=line.charAt(j);
                if(map[i][j]=='*'){
                    wQueue.add(new Point(i, j));
                }else if(map[i][j]=='S'){
                    sQueue.add(new Point(i, j));
                    sVisit[i][j]=true;
                }
            }
        }
        int ans = bfs();
        System.out.println(ans==-1?"KAKTUS":ans);

    }

    private static int bfs() {
        int time = 0;
        while(!sQueue.isEmpty()){
            time++;

            // 홍수
            int qSize = wQueue.size();
            for(int s=0; s<qSize; s++){
                Point w = wQueue.poll();
                for(int d=0; d<4; d++){
                    int ni = w.i + didj[d][0];
                    int nj = w.j + didj[d][1];
                    if(ni<0||nj<0||ni>=R||nj>=C) continue;
                    if(map[ni][nj]=='.'){
                        wQueue.add(new Point(ni, nj));
                        map[ni][nj]='*';
                    }
                }
            }

            // 고슴도치 이동
            qSize = sQueue.size();
            for(int s=0; s<qSize; s++){
                Point p = sQueue.poll();
                for(int d=0; d<4; d++){
                    int ni = p.i + didj[d][0];
                    int nj = p.j + didj[d][1];
                    if(ni<0||nj<0||ni>=R||nj>=C||sVisit[ni][nj]) continue;
                    if(map[ni][nj]=='D') {
                        return time;
                    }
                    if(map[ni][nj]=='.'){
                        sQueue.add(new Point(ni, nj));
                        sVisit[ni][nj]=true;
                    }
                }
            }

        }
        return -1;
    }

}
