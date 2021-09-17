package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16208_귀찮음 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] nums = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long totalLen = 0;
        for(int i=0; i<N; i++){
            long num = Long.parseLong(st.nextToken());
            totalLen += num;
            nums[i] = num;
        }

        long ans = 0;
        for(int i=0; i<=N-2; i++){
            ans += nums[i]*(totalLen-nums[i]);
            totalLen -= nums[i];
        }
        System.out.println(ans);

    }

}
