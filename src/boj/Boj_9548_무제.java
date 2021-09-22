package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9548_무제 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringBuilder s = new StringBuilder(br.readLine());
            while(true){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                if(cmd.equals("END")) break;
                if(cmd.equals("I")){
                    String r = st.nextToken();
                    int x = Integer.parseInt(st.nextToken());
                    if(s.length()==x){
                        s.append(r);
                    }else{
                        s.insert(x, r);
                    }
                }else if(cmd.equals("P")){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    sb.append(s.substring(x, y+1)).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }

}
