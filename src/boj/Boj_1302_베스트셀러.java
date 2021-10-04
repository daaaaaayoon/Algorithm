package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Boj_1302_베스트셀러 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        while(N-->0){
            String title = br.readLine();
            if(map.containsKey(title)){
                map.replace(title, map.get(title)+1);
            }else{
                map.put(title, 1);
            }
        }
        int max = 0;
        for(String s : map.keySet()){
            max = Math.max(max, map.get(s));
        }

        ArrayList<String> books = new ArrayList<>(map.keySet());
        Collections.sort(books); // 사전 순 정렬
        for(String s : books){
            if(map.get(s)==max){
                System.out.println(s);
                return;
            }
        }
    }

}
