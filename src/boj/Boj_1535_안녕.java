package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1535_안녕 {

    static int N, ans;
    static int[] L, J;
    static boolean[] select;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        L = new int[N];
        J = new int[N];
        select = new boolean[N];
        ans = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            L[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            J[i]=Integer.parseInt(st.nextToken());
        }
        subset(0);
        System.out.println(ans);
    }

    private static void subset(int cnt) {
        if(cnt == N){
            ans = Math.max(ans, getMax());
            return;
        }
        select[cnt]=true;
        subset(cnt+1);
        select[cnt]=false;
        subset(cnt+1);
    }

    private static int getMax() {
        int l = 0; int j = 0;
        for(int i=0; i<N; i++){
            if(select[i]){
                l += L[i];
                j += J[i];
            }
        }
        if(100-l<=0) return 0;
        return j;
    }

}
