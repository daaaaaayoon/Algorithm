package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9102_괄호_count {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            System.out.println(solve(br.readLine()));
        }
    }

    private static String solve(String str) {

        int count = 0;

        for(int i=0; i<str.length(); i++) {

            char ch = str.charAt(i);
            if(ch == '(') {
                count++;
            }else if(count == 0) {
                return "NO";
            }else {
                count--;
            }
        }

        if(count == 0) return "YES";
        else return "NO";

    }

}
