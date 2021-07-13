package algo_202107.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_10610_30 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String str = br.readLine();
        char[] nums = str.toCharArray();

        // 자릿수의 합 구히기 & 0이 존재하는지 검사
        boolean zero = false;
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i] -'0';
            if(nums[i] == '0') zero = true;
        }

        if(sum%3==0 && zero) {
            Arrays.sort(nums);
            ans = new StringBuilder(new String(nums));
            System.out.println(ans.reverse().toString());
        }else {
            System.out.println(-1);
        }

    }

}
