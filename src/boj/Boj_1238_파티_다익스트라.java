package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1238_파티_다익스트라 {

    static int N, M, X;
    static boolean[] visit;
    static int[][] dist;
    static List<Edge>[] edgeList;
    static class Edge implements Comparable<Edge>{
        int num, weight;
        Edge(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i]=0;
        }

        edgeList = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            edgeList[i]=new ArrayList<>();
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[start].add(new Edge(end, weight));
        }

        for(int i=1; i<=N; i++){
            dijk(i);
        }

        int ans = -1;
        for(int i=1; i<=N; i++){
            ans = Math.max(ans, dist[i][X]+dist[X][i]);
        }
        System.out.println(ans);

    }

    private static void dijk(int i) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(i, 0));
        visit = new boolean[N+1];
        while(!pq.isEmpty()){
            int num = pq.poll().num;
            if(visit[num]) continue;
            visit[num]=true;
            for(Edge e : edgeList[num]){
                if(dist[i][e.num]>dist[i][num]+e.weight){
                    dist[i][e.num]=dist[i][num]+e.weight;
                    pq.add(new Edge(e.num, dist[i][e.num]));
                }
            }
        }

    }

}
