package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_3273_두수의합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i]=Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(num);
        int start = 0;
        int end = N-1;
        int ans = 0;
        int sum = 0;
        while (start < end) {
            sum = num[start] + num[end];

            if (sum == x) ans++;

            if (sum <= x) start++;
            else end--;
        }
        System.out.println(ans);
    }

}
