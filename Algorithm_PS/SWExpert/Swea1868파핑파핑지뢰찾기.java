package SWEA;

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
    static int cnt;// 지뢰의 수
     
    static int[] di = {1,-1,0,0,1,-1,-1,1}; // 8방 탐색
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
            count = new int[N][N]; // 8방으로 지뢰가 몇개 있는지를 저장하는 배열
            visit = new boolean[N][N];
            
            for(int i=0; i<N; i++) {
                String line = br.readLine();
                for(int j=0; j<N; j++) {
                    map[i][j] = line.charAt(j);
                    if(map[i][j]=='*') {
                        count[i][j] = -1; // 지뢰는 -1로 표시한다.
                    }
                }
            }
             
            // 8방 탐색을 통해서 배열 count[][]에 주변에 지뢰가 몇개 있는지를 저장한다.
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(count[i][j]==-1) continue; // 지뢰인 경우 주변에 지뢰가 몇개인지 알필요 없음
                    cnt = 0; // 지뢰수 초기화
                    bfs(i, j); // 지뢰수 알아오기
                    count[i][j] = cnt; // 지뢰수 넣어주기
                }
            }
             
            // count배열에서 0으로 표시된 부분을 먼저 클릭한다. visit처리를 통해서 클릭된 부분 구분하기
            // clickCnt에 클릭된 횟수를 구한다.
            int clickCnt = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visit[i][j] && count[i][j]==0) {
                        click(i, j);
                        clickCnt++;
                    }
                }
            }
            
            // 이제 클릭되지 않은 칸 중에 숫자가 있는 칸을 모두 누르면 끝
            // numCnt에 클릭된 횟수를 구한다.
            int numCnt=0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visit[i][j] && count[i][j]!=-1) {
                        numCnt++;
                    }
                }
            }
            
            // 산술연산,, 맨앞부터 붙어버려서 이렇게 하면 안됨 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            // System.out.println("#"+tc+" "+clickCnt+numCnt);
            System.out.println("#"+tc+" "+(clickCnt+numCnt)); // 클릭된 횟수를 더해주면 끝
        }
    }
     
    // count배열에서 0인 부분을 클릭하면, 주변으로 퍼져나가면서 큐에 넣는 메소드
    private static void click(int i, int j) {
         
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        visit[i][j] = true;
         
        while(!queue.isEmpty()) {
             
            Point n = queue.poll();
             
            if(count[n.i][n.j]>0) continue; // 0이 아닌 경우 8방 탐색할 필요없으므로 넘어간다!!
             
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
 
    // 8방탐색으로 주변에 지뢰가 몇개있는지 count에 저장하는 메소드
    private static void bfs(int i, int j) {
        for(int d=0; d<8; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
            if(map[ni][nj]=='*') cnt++; // 지뢰의 수
        }
    }
}