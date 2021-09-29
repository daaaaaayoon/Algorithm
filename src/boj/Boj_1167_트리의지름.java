package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1167_트리의지름 {

    static int V, farIdx, ans;
    static boolean[] visit;
    static List<Edge>[] list;
    static class Edge{
        int num, weight;
        Edge(int num, int weight){
            this.num=num;
            this.weight=weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        visit = new boolean[V+1];
        list = new ArrayList[V+1];
        for(int i=1; i<=V; i++){
            list[i]=new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=1; i<=V; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while(true){
                int v = Integer.parseInt(st.nextToken());
                if(v==-1) break;
                int weight = Integer.parseInt(st.nextToken());
                list[start].add(new Edge(v, weight));
            }
        }
        // 1. 임의의 노드에서 bfs, dfs를 사용하여 최대 길이 인 노드를 찾는다.
        dfs(1, 0);
        // 2. 해당 노드를 시작으로 다시 bfs, dfs를 사용하여 최대 길이인 노드를 찾고 그 길이가 최장 길이이다.
        dfs(farIdx, 0);
        System.out.println(ans);
    }

    private static void dfs(int v, int sum) {
        if(ans<sum){
            farIdx=v;
            ans=sum;
        }
        visit[v]=true;
        for(Edge e : list[v]){
            if(!visit[e.num]){
                dfs(e.num, sum+e.weight);
            }
        }
        visit[v]=false;
    }

}
