package algo_202107.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.temporal.ChronoField;
import java.util.Stack;

public class Boj_9102_괄호_stack {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            System.out.println(solve(br.readLine()));
        }

    }

    private static String solve(String str) {

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++) {

            char ch = str.charAt(i);
            if(ch == '(') {
                stack.push(ch);
            }else if(stack.empty()) {
                return "NO";
            }else{
                stack.pop();
            }

        }

        if(stack.empty()) return "YES";
        else return "NO";

    }


}
