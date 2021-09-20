package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17141_연구소2 {

    static int N, M, ans;
    static int[][] map;
    static ArrayList<Point> arr;
    static Point[] pick;
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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 놓을 수 있는 바이러스의 수 (!=map에 있는 2의 수)
        map = new int[N][N];
        arr = new ArrayList<>();
        pick = new Point[M];
        ans = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==2) arr.add(new Point(i, j));
            }
        }
        comb(0, 0);

        System.out.println(ans==Integer.MAX_VALUE?-1:ans);
    }

    private static void comb(int cnt, int start) {
        if(cnt==M){
            bfs();
            return;
        }
        for(int i=start; i<arr.size(); i++){
            pick[cnt]=arr.get(i);
            comb(cnt+1, i+1);
        }
    }

    private static void bfs() {

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];

        for(int i=0; i<M; i++){
            Point v = pick[i];
            queue.add(v);
            visit[v.i][v.j]=true;
        }

        int time = 0;
        while(!queue.isEmpty()){
            int qSize = queue.size();
            for(int s=0; s<qSize; s++){
                Point v = queue.poll();
                for(int d=0; d<4; d++){
                    int ni = v.i + didj[d][0];
                    int nj = v.j + didj[d][1];
                    if(ni<0||ni>=N||nj<0||nj>=N||
                            visit[ni][nj]||map[ni][nj]==1) continue;
                    if(map[ni][nj]==0 || map[ni][nj]==2){
                        queue.add(new Point(ni, nj));
                        visit[ni][nj]=true;
                    }
                }
            }
            time++;
        }

        // 모두 퍼트렸는지 확인
        boolean done = true;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==0 && !visit[i][j]) {
                    done = false;
                    break;
                }
            }
        }
        if(done) ans = Math.min(ans, time-1);

    }

}
