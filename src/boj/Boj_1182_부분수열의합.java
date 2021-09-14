package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1182_부분수열의합 {

    static int N, S, ans;
    static int[] nums;
    static boolean[] select;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];
        select = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        subset(0);
        System.out.println(ans);
    }

    private static void subset(int cnt) {
        if(cnt == N){
            int sum = 0;
            boolean flag = false; // 공집합 제외하기 위함
            for(int i=0; i<N; i++){
                if(select[i]) {
                    sum += nums[i];
                    flag = true;
                }
            }
            if(flag && sum == S) ans++;
            return;
        }
        select[cnt] = true;
        subset(cnt+1);
        select[cnt] = false;
        subset(cnt+1);
    }

}
