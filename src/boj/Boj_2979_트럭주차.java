package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2979_트럭주차 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] fee = new int[3];
        for(int i=0; i<3; i++) {
            fee[i]=Integer.parseInt(st.nextToken());
        }

        int[] time  = new int[101];
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for(int j=start; j<end; j++) {
                time[j]++;
            }
        }

        int ans=0;
        for(int i=1; i<time.length; i++) {
            if(time[i]==3) {
                ans+=fee[2]*3;
            }else if(time[i]==2) {
                ans+=fee[1]*2;
            }else if(time[i]==1) {
                ans+=fee[0];
            }
        }

        System.out.println(ans);

    }

}
