package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_1764_듣보잡 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int j=0; j<M; j++){
            String name = br.readLine();
            if(set.contains(name)){
                ans.add(name);
            }
        }
        Collections.sort(ans);
        System.out.println(ans.size());
        for(String s : ans){
            System.out.println(s);
        }
    }

}
