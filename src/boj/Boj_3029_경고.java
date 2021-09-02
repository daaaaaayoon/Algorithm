package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3029_경고 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cur = new int[3];
        for(int i=0; i<3; i++){
            cur[i] = Integer.parseInt(st.nextToken(":"));
        }

        st = new StringTokenizer(br.readLine());
        int[] attack = new int[3];
        for(int i=0; i<3; i++){
            attack[i] = Integer.parseInt(st.nextToken(":"));
        }

        boolean same = true;
        for(int i=0; i<3; i++){
            if(cur[i]!=attack[i]) same = false;
        }
        if(same) {
            System.out.println("24:00:00");
            return;
        }

        for(int i=2; i>=0; i--){
            int base = i==0?24:60;
            if(cur[i]>attack[i]){
                cur[i]=base-cur[i]+attack[i];
                if(i!=0) cur[i-1]++;
            }else{
                cur[i]=attack[i]-cur[i];
            }
        }

        for(int i=0; i<3; i++){
            System.out.print(cur[i]<10?"0"+cur[i]:cur[i]);
            if(i!=2) System.out.print(":");
        }

    }

}
