package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_5567_결혼식 {

    static int n, m, ans;
    static int[][] map;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        visit = new boolean[n+1];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            map[v1][v2] = 1;
            map[v2][v1] = 1;
        }

        bfs();
        System.out.println(ans);

    }

    private static void bfs() {

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(new Vertex(1, 0));
        visit[1] = true;

        while(!queue.isEmpty()) {

            Vertex v = queue.poll();

            if(v.dist>=2)  continue;

            for(int i=1; i<=n; i++) {
                if(map[v.num][i]==1 && !visit[i]) {
                    queue.add(new Vertex(i, v.dist+1));
                    visit[i] = true;
                    ans++;
                }
            }

        }

    }

    static class Vertex {
        int num, dist;
        Vertex(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }

}

