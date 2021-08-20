package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1182_부분수열의합 {

    static int N, S, ans;
    static int[] number;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        isSelected = new boolean[N];
        number = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        subset(0);

        System.out.println(ans);

    }

    private static void subset(int cnt) {

        if(cnt == N) {

            boolean none = true;
            int sum = 0;
            for(int i=0; i<N; i++) {
                if(isSelected[i]) {
                    none = false;
                    sum+=number[i];
                }
            }
            if(!none && sum == S) ans++;

            return;
        }

        isSelected[cnt] = true;
        subset(cnt+1);
        isSelected[cnt] = false;
        subset(cnt+1);
    }

}
