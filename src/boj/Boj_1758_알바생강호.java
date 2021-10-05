package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_1758_알바생강호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] money = new int[N];
        for(int i=0; i<N; i++){
            money[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(money);
        long answer = 0;
        for(int i=N-1; i>=0; i--){
            int tip = money[i]-((N-1)-i);
            if(tip>0) answer += tip;
        }
        System.out.println(answer);
    }

}
