package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10971_외판원순회2 {

    static int N, start, ans;
    static int[][] w;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        w = new int[N][N];
        visit = new boolean[N];
        ans = Integer.MAX_VALUE;
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            start = i; // 출발 좌표 기억
            dfs(i, 0, 0);
        }
        System.out.println(ans);
    }

    private static void dfs(int i, int cnt, int cost) {

        // 안해도 정답이지만, N개를 뽑기전에 시작점을 이미 방문한 경우는 제외할 수도 있음
        if(cnt<N && visit[start]) return;

        if(cnt == N && start == i){ // 모두 방문하고, 맨 마지막에 시작정점을 방문하는 경우에만
            ans = Math.min(ans, cost+w[i][start]);
            return;
        }

        for(int j=0; j<N; j++){
            if(i==j || visit[j] || w[i][j]<=0) continue; // 놓친 조건 : 비용이 0인 지점은 갈 수 없는 지점
            visit[j] = true;
            if(cost+w[i][j] < ans) dfs(j, cnt+1, cost+w[i][j]); // 가지치기
            visit[j] = false;
        }

    }

}
