package algo_202108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10819_차이를최대로 {

    static int N, ans;
    static int[] arr, nums;
    static boolean[] select;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        nums = new int[N];
        select = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);

        System.out.println(ans);

    }

    private static void perm(int cnt) {

        if(cnt == N) {
            int sum = 0;
            for(int i=0; i<N-1; i++) {
                sum += Math.abs(nums[i]-nums[i+1]);
            }
            ans = Math.max(ans, sum);
            return;
        }
        for(int i=0; i<N; i++) {
            if(select[i]) continue;
            nums[cnt] = arr[i];
            select[i] = true;
            perm(cnt+1);
            select[i] = false;
        }

    }

}
