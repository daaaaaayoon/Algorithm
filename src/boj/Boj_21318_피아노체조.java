package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_21318_피아노체조 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] grade = new long[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            grade[i]=Integer.parseInt(st.nextToken());
        }

        // 실수 누적하기
        int[] mistake = new int[N+1];
        for(int i=1; i<N; i++){
            if(grade[i+1]<grade[i]){
                mistake[i]=mistake[i-1]+1;
            }else{
                mistake[i]=mistake[i-1];
            }
        }
        mistake[N]=mistake[N-1];

        // 피아노 체조
        int Q = Integer.parseInt(br.readLine());
        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            // 마지막 연주는 실수하지 않고 시작하는 연주의 실수를 포함해야하므로
            System.out.println(mistake[end-1]-mistake[start-1]);
        }

    }

}
