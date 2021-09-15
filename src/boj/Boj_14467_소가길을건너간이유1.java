package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14467_소가길을건너간이유1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[101];
        int[] location = new int[101];
        for(int i=1; i<=100; i++){
            location[i] = -1;
        }

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int cowNum = Integer.parseInt(st.nextToken());
            int cowLoc = Integer.parseInt(st.nextToken());
            // 초기 상태의 위치
            if(location[cowNum]==-1){
                location[cowNum] = cowLoc;
            }else if(location[cowNum]!=cowLoc){
                location[cowNum] = cowLoc;
                count[cowNum]++;
            }
        }

        int ans = 0;
        for(int i=1; i<=100; i++){
            ans += count[i];
        }
        System.out.println(ans);

    }

}
