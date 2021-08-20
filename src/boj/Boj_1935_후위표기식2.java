package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_1935_후위표기식2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] cal = br.readLine().toCharArray();

        int[] alphabet = new int[26];
        for(int n=0; n<N; n++) {
            alphabet[n] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for(int c=0; c<cal.length; c++) {
            if(65 <= cal[c] && cal[c] <= 90) {
                stack.push((double) (alphabet[cal[c]-65]));
            }else {
                double back = stack.pop();
                double front = stack.pop();
                switch (cal[c]) {
                    case '*' :
                        stack.push(front*back);
                        break;
                    case '+' :
                        stack.push(front+back);
                        break;
                    case '-' :
                        stack.push(front-back);
                        break;
                    case '/' :
                        stack.push(front/back);
                        break;
                }
            }
        }

        System.out.printf("%.2f", stack.pop());

    }

}
