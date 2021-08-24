package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1547_공 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[] cups = new boolean[4];
        cups[1] = true;
        int N = Integer.parseInt(br.readLine());

        while(N-- >0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            boolean tmp = cups[x];
            cups[x] = cups[y];
            cups[y] = tmp;
        }
        for(int i=1; i<cups.length; i++) {
            if(cups[i]) {
                System.out.println(i);
                break;
            }
        }
    }

}

