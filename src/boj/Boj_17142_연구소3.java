package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17142_연구소3 {

    static int N, M, ans;
    static int[][] map;
    static boolean[][] visit;
    static int[][] didj = {{-1,0},{0,-1},{1,0},{0,1}};
    static ArrayList<Point> vList;
    static Point[] select;
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
        map = new int[N][N];
        select = new Point[M];
        vList = new ArrayList<>();
        ans = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    vList.add(new Point(i, j));
                }
            }
        }
        comb(0, 0);
        System.out.println(ans==Integer.MAX_VALUE?-1:ans);
    }

    private static void comb(int cnt, int start) {
        if(cnt == M){
            int time = bfs();
            if(time!=-1) ans=Math.min(ans, time);
            return;
        }
        for(int i=start; i<vList.size(); i++){
            select[cnt]=vList.get(i);
            comb(cnt+1, i+1);
        }
    }

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        visit = new boolean[N][N];
        for(Point p : select){
            queue.add(p);
            visit[p.i][p.j]=true;
        }
        int time = 0;
        while(!queue.isEmpty()){
            if(check()) return time;
            int qSize = queue.size();
            for(int s=0; s<qSize; s++){
                Point p = queue.poll();
                for(int d=0; d<4; d++){
                    int ni = p.i+didj[d][0];
                    int nj = p.j+didj[d][1];
                    if(ni<0||ni>=N||nj<0||nj>=N) continue;
                    if(!visit[ni][nj] && map[ni][nj]!=1){
                        queue.add(new Point(ni, nj));
                        visit[ni][nj]=true;
                    }
                }
            }
            time++;
        }
        return -1;
    }

    private static boolean check() {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==0 && !visit[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

}
