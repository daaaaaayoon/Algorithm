package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9501_꿍의우주여행 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        while(TC-->0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for(int n=0; n<N; n++) {
                st = new StringTokenizer(br.readLine());
                double v = Integer.parseInt(st.nextToken());
                double f = Integer.parseInt(st.nextToken());
                double c = Integer.parseInt(st.nextToken());
                double maxDist = (f / c) * v;
                if(maxDist>=D) cnt++;
            }
            System.out.println(cnt);
        }

    }

}
