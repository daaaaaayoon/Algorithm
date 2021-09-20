package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16938_캠프준비 {

    static int N, X, ans;
    static long L, R;
    static int[] grade;
    static boolean[] select;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Long.parseLong(st.nextToken());
        R = Long.parseLong(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        grade = new int[N];
        select = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            grade[i]=Integer.parseInt(st.nextToken());
        }
        subset(0);
        System.out.println(ans);

    }

    private static void subset(int cnt) {
        if(cnt == N){

            int count=0; long sum=0;
            int max=0; int min = Integer.MAX_VALUE;
            for(int i=0; i<N; i++){
                if(select[i]){
                    ++count;
                    sum+=grade[i];
                    max = Math.max(max, grade[i]);
                    min = Math.min(min, grade[i]);
                }
            }

            if(count>=2 && L<=sum && sum<=R && max-min>=X){
                ans++;
            }
            return;
        }
        select[cnt]=true;
        subset(cnt+1);
        select[cnt]=false;
        subset(cnt+1);
    }

}
