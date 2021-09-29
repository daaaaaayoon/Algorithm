package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1120_문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        int aLen = A.length();
        int bLen = B.length();
        int diff = Integer.MAX_VALUE;
        for(int i=0; i<=bLen-aLen; i++){
            int cnt = 0;
            for(int j=i; j<i+aLen; j++){
                if(A.charAt(j-i)!=B.charAt(j)){
                    cnt++;
                }
            }
            diff = Math.min(diff, cnt);
        }
        System.out.println(diff);
    }

}
