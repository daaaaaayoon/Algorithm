package algo_202107.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_1427_소트인사이드 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);

        int[] nums = new int[str.length()];
        int idx = 0;
        while(N>0) {
            nums[idx++] = N%10;
            N/=10;
        }

        Arrays.sort(nums);
        for(int i=nums.length-1; i>=0; i--) {
            System.out.print(nums[i]);
        }

    }

}
