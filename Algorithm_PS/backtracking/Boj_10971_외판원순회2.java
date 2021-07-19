package algo_202107.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10971_외판원순회2 {

    static int N, depart, min;
    static int[][] dist;
    static boolean[] visit;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dist = new int[N][N];
        visit = new boolean[N];
        min = Integer.MAX_VALUE;

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 각각의 도시에서 dfs 시작하기
        for(int i=0; i<N; i++) {
            dfs(i, i, 0, 0);
        }

        System.out.println(min);

    }

    private static void dfs(int start, int v, int cnt, int sum) {

        // 3. 모든 지점을 방문한 이후, 시작점으로 돌아온 경우
        if(cnt == N && start == v) {
            min = Math.min(min, sum);
            return;
        }

        // 2. 출발점 v에서 갈 수 있는 정점을 탐색
        for(int i=0; i<N; i++) {
            // 이미 방문한적 있는 경우 제외 && 비용의 값이 0인 경우(이동 불가) 제외
            if(!visit[i] && dist[v][i]>0) {
                // 방문 처리
                visit[i] = true;
                // 경로의 비용이 min보다 큰 경우는 제외 (가지치기)
                if(sum+dist[v][i] < min) dfs(start, i, cnt+1, sum+dist[v][i]);
                // 방문 처리 해제 (i를 선택하지 않았던 시점으로 돌아와서 다시 탐색해야하기 때문에)
                visit[i] = false;
            }
        }

    }

}
