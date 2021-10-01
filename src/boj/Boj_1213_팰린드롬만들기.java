package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1213_팰린드롬만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = new int[26];
        String str = br.readLine();
        for(char c : str.toCharArray()){
            alpha[c-'A']++;
        }
        int mid = 0;
        int cnt = 0;
        for(int i=0; i<26; i++){
            if(alpha[i]%2==1){
                cnt++;
                mid=i;
            }
        }
        if((str.length()%2==0 && cnt>0)||(str.length()%2==1 && cnt>1)){
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < alpha[i] / 2; j++) {
                sb.append((char)(i + 'A'));
            }
        }
        String reverse = new StringBuilder(sb).reverse().toString();
        if(cnt==1){
            sb.append((char)(mid+'A')).append(reverse);
        }else{
            sb.append(reverse);
        }
        System.out.println(sb);
    }

}
