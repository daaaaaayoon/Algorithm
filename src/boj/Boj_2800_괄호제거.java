package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.TreeSet;

public class Boj_2800_괄호제거 {

    static String str;
    static ArrayList<Pair> pairs;
    static ArrayList<String> ans;
    static TreeSet<String> set;
    static class Pair{
        int open, close;
        Pair(int open, int close){
            this.open = open;
            this.close = close;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        pairs = new ArrayList<>();
//        ans = new ArrayList<>();
        set = new TreeSet<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='('){
                stack.push(i);
            }else if(str.charAt(i)==')'){
                int s = stack.pop();
                pairs.add(new Pair(s, i));
            }
        }
        dfs(0, str);
//        Collections.sort(ans);
        for(String a : set){
            System.out.println(a);
        }
    }

    private static void dfs(int idx, String s) {
        for(int i=idx; i<pairs.size(); i++){
            Pair p = pairs.get(i);
            StringBuilder sb = new StringBuilder(s);
            sb.replace(p.open, p.open+1, " ");
            sb.replace(p.close, p.close+1, " ");
            set.add(sb.toString().replaceAll(" ", ""));
            dfs(i+1, sb.toString());
            sb.replace(p.open, p.open+1, "(");
            sb.replace(p.close, p.close+1, ")");
        }
    }

}
