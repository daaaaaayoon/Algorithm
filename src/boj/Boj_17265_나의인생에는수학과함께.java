package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17265_나의인생에는수학과함께 {

    static int N, max, min;
    static char[][] map;
    static int[][] didj = {{1,0}, {0,1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j]=st.nextToken().charAt(0);
            }
        }
        dfs(0, 0, map[0][0]-'0', 0);
        System.out.println(max+" "+min);

    }

    private static void dfs(int i, int j, int sum, int oper) {
        if(i==N-1 && j==N-1){
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for(int d=0; d<2; d++){
            int ni = i + didj[d][0];
            int nj = j + didj[d][1];
            if(ni<0||ni>=N||nj<0||nj>=N) continue;
            if(map[ni][nj]=='+'){
                dfs(ni, nj, sum, 1);
            }else if(map[ni][nj]=='-'){
                dfs(ni, nj, sum, 2);
            }else if(map[ni][nj]=='*'){
                dfs(ni, nj, sum, 3);
            }else{ // 숫자라면 계산
                switch (oper){
                    case 1:
                        dfs(ni, nj, sum+(map[ni][nj]-'0'), 0);
                        break;
                    case 2:
                        dfs(ni, nj, sum-(map[ni][nj]-'0'), 0);
                        break;
                    case 3:
                        dfs(ni, nj, sum*(map[ni][nj]-'0'), 0);
                        break;
                }
            }
        }

    }

}
