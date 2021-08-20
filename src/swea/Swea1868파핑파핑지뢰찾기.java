package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class Swea1868파핑파핑지뢰찾기 {
 
    static int N;
    static char[][] map;
    static int[][] count;
    static boolean[][] visit;
    static int cnt;
     
    static int[] di = {1,-1,0,0,1,-1,-1,1};
    static int[] dj = {0,0,-1,1,1,-1,1,-1};
     
    static class Point{
        int i, j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++) {
            N = Integer.parseInt(br.readLine());
             
            map = new char[N][N];
            count = new int[N][N];
            visit = new boolean[N][N];
            
            for(int i=0; i<N; i++) {
                String line = br.readLine();
                for(int j=0; j<N; j++) {
                    map[i][j] = line.charAt(j);
                    if(map[i][j]=='*') {
                        count[i][j] = -1;
                    }
                }
            }
             
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(count[i][j]==-1) continue;
                    cnt = 0;
                    bfs(i, j);
                    count[i][j] = cnt;
                }
            }
             
            int clickCnt = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visit[i][j] && count[i][j]==0) {
                        click(i, j);
                        clickCnt++;
                    }
                }
            }
            
            int numCnt=0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visit[i][j] && count[i][j]!=-1) {
                        numCnt++;
                    }
                }
            }
            
            System.out.println("#"+tc+" "+(clickCnt+numCnt));
        }
    }
     
    private static void click(int i, int j) {
         
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        visit[i][j] = true;
         
        while(!queue.isEmpty()) {
             
            Point n = queue.poll();
             
            if(count[n.i][n.j]>0) continue;
             
            for(int d=0; d<8; d++) {
                int ni = n.i + di[d];
                int nj = n.j + dj[d];
                if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
                if(!visit[ni][nj]&& count[ni][nj]!=-1) {
                    queue.add(new Point(ni, nj));
                    visit[ni][nj] = true;
                }
            }
        }
     
    }
 
    private static void bfs(int i, int j) {
        for(int d=0; d<8; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
            if(map[ni][nj]=='*') cnt++;
        }
    }
}