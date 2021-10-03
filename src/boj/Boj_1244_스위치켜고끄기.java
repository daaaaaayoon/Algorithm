package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1244_스위치켜고끄기 {

    static int N;
    static int[] swit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        swit = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            swit[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(s==1){ // 남
                for(int i=1; i<=N; i++){
                    if(num*i>N) break;
                    swit[num*i]=(swit[num*i]+1)%2;
                }
            }else if(s==2){ // 여
                swit[num]=(swit[num]+1)%2;
                int a = 1;
                while(true){
                    int start = num-a;
                    int end = num+a;
                    if(start>=1 && start<=N && end>=1 && end<=N){
                        if(swit[start]==swit[end]){
                            swit[start]=(swit[start]+1)%2;
                            swit[end]=(swit[end]+1)%2;
                            a++;
                            continue;
                        }
                    }
                    break;
                }
            }
        }
        for(int i=1; i<=N; i++){
            System.out.print(swit[i]+" ");
            if(i%20==0) System.out.println();
        }
    }

}
