package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 다익스트라 - priority queue
public class Boj_17396_백도어 {

    static int N, M;
    static long[] distance;
    static boolean[] visit;
    static List<Edge>[] edgeList;

    static class Edge implements Comparable<Edge>{
        int num;
        long dist;
        Edge(int num, long dist){
            this.num = num;
            this.dist = dist;
        }
        @Override
        public int compareTo(Edge o) {
            if(this.dist<o.dist) return -1;
            else if(this.dist==o.dist) return 0;
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int x=Integer.parseInt(st.nextToken());
            if(x==1) visit[i]=true; // 1인 부분은 방문하지 못하도록 방문처리 해둔다.
        }

        edgeList=new ArrayList[N];
        for(int i=0; i<N; i++){
            edgeList[i]=new ArrayList<>();
        }

        distance = new long[N];
        Arrays.fill(distance, Long.MAX_VALUE);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            edgeList[start].add(new Edge(end, dist));
            edgeList[end].add(new Edge(start, dist));
        }

        System.out.println(dijk());

    }

    static long dijk(){
        PriorityQueue<Edge> pq = new PriorityQueue();
        pq.add(new Edge(0, 0));
        distance[0]=0;
        while(!pq.isEmpty()){
            int cur = pq.poll().num;
            if(cur==N-1) return distance[N-1];
            if(visit[cur]) continue; // cur에서 모든 정점을 탐색해보았다면 더 이상 진행하지 않음
            visit[cur]=true;
            for(Edge e : edgeList[cur]){
                if(distance[e.num]>distance[cur]+e.dist){
                    distance[e.num]=distance[cur]+e.dist;
                    pq.add(new Edge(e.num, distance[e.num]));
                }
            }
        }
        return -1;
    }

}
