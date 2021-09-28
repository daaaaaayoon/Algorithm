package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1065_한수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 1. 100 이하의 수는 모두 한수
        if(N<100){
            System.out.println(N);
            return;
        }
        // 2. 100 이상인 경우
        int cnt = 99;
        for(int i=100; i<=N; i++){
            int p = i%10;
            int m = i/10;
            int n = m%10;
            int diff = p-n;
            while(true){
                int pre = m%10;
                int next = (m/10)%10;
                if(diff!=pre-next) break;
                m/=10;
                if(m/10==0){
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }

}
