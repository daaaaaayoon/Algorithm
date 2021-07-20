package algo_202107.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_1874_스택수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int start = 0;
        while(N-- >0) {

            int val = Integer.parseInt(br.readLine());

            if(start < val) {

                for(int i=start+1; i<=val; i++) {
                    stack.push(i);
                    sb.append("+\n");
                }
                start = val;

            }else if(stack.peek() != val) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-\n");

        }
        System.out.println(sb.toString());



    }

}
