package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_5677_할아버지는유명해 {

    static int N, M;
    static int[] player;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N==0 && M==0) break;
            player = new int[10001];
            for(int i=1; i<=N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=M; j++){
                    player[Integer.parseInt(st.nextToken())]+=1;
                }
            }
            // 0이 아니면서 가장 점수가 낮은 플레이어가 1등
            int maxIdx = 0;
            int max = Integer.MIN_VALUE;
            for(int i=1; i<=10000; i++){
                if(player[i]==0) continue;
                if(max<player[i]){
                    max=player[i];
                    maxIdx=i;
                }
            }
            // 1등 점수를 0으로 만든다.
            player[maxIdx]=0;
            // 이제 여기서 0이 아닌 가장 점수가 낮은 플레이어가 2등
            max = Integer.MIN_VALUE;
            for(int i=1; i<=10000; i++){
                if(player[i]==0) continue;
                if(max<player[i]){
                    max=player[i];
                    maxIdx=i;
                }
            }
            // 2등 모으기
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i=1; i<=10000; i++){
                if(player[maxIdx]==player[i]){
                    ans.add(i);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int a : ans){
                sb.append(a).append(" ");
            }
            System.out.println(sb.toString());
        }
    }

}
