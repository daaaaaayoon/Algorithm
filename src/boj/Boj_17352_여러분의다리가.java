package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17352_여러분의다리가 {

    static int N;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        p = new int[N+1];
        // 1. make-set
        for(int i=1; i<=N; i++){
            p[i]=i;
        }
        // 2. union
        StringTokenizer st;
        for(int i=1; i<=N-2; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            union(v1, v2);
        }
        // 3. 연결되지 않은 다리가 발견된다면 출력 후 종료
        int root = find(1);
        for(int i=2; i<=N; i++){
            if(root!=find(i)){
                System.out.println(root+" "+i);
                return;
            }
        }
    }

    private static void union(int v1, int v2) {
        int a = find(v1);
        int b = find(v2);
        if(a!=b){
            p[a]=b;
        }
    }

    private static int find(int a) {
        if(p[a]==a) return a;
        return p[a]=find(p[a]);
    }

}
