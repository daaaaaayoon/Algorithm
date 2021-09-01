package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 재채점으로 이후 자바 코드에서 시간초과가 나는 문제
// base : [ 각 정점에 대해 재귀함수가 호출되는 횟수 = 해킹할 수 있는 컴퓨터의 갯수 ] ⭐️
public class Boj_1325_효율적인해킹 {

    static int N, M, maxCnt;
    static int[] rank;
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rank = new int[N+1];
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        // bfs

        for(int i=1; i<=N; i++){
            bfs(i);
        }

        int max=0;
        for(int a : rank){
            max = Math.max(a, max);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            if(max==rank[i]) sb.append(i+" ");
        }
        System.out.println(sb.toString());

    }

    private static void bfs(int i) {
        visit = new boolean[N+1];
        queue = new LinkedList<>();
        visit[i]=true;
        queue.add(i);

        int cnt=0;
        while(!queue.isEmpty()) {
            int n = queue.poll();
            for(int a : list[n]){
                if(!visit[a]){
                    rank[a]++;
                    queue.add(a);
                    visit[a]=true;
                }
            }
        }

    }

}
