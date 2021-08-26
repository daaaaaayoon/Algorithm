package pgm;

import java.util.Arrays;

// mst
public class Solution섬연결하기 {

    static int[] p;
    static Edge[] edgeList;

    static class Edge implements Comparable<Edge> {
        int start, end, weight;
        Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }
    }

    public static void main(String[] args) {

        int[][] cost = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        int ans = solution(4, cost);
        System.out.println(ans);

    }

    static int solution(int n, int[][] costs) {

        p = new int[n];
        edgeList = new Edge[costs.length];

        for(int i=0; i<costs.length; i++) {
            int v1 = costs[i][0];
            int v2 = costs[i][1];
            int c = costs[i][2];
            edgeList[i] = new Edge(v1, v2, c);
        }
        Arrays.sort(edgeList);

        makeset(n);
        int ans = 0;
        int edgeCnt = 0;
        for(Edge e : edgeList){
            if(union(e.start, e.end)) {
                ans+=e.weight;
                if(++edgeCnt==n-1) break;
            }
        }

        return ans;
    }

    private static boolean union(int start, int end) {
        int aRoot = find(start);
        int bRoot = find(end);
        if(aRoot!=bRoot) {
            p[bRoot]=aRoot;
            return true;
        }
        return false;
    }

    private static int find(int a) {
        if(p[a]==a) return a;
        return p[a]=find(p[a]);
    }

    private static void makeset(int n) {
        for(int i=0; i<n; i++) {
            p[i]=i;
        }
    }

}
