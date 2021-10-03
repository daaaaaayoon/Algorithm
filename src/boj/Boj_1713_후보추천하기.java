package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1713_후보추천하기 {

    static int N;
    static int[] rec;
    static class Student implements Comparable<Student> {
        int num, reco, time;
        Student(int num, int reco, int time){
            this.num = num;
            this.reco = reco;
            this.time = time;
        }
        @Override
        public int compareTo(Student o) {
            if(this.reco==o.reco){
                return this.time-o.time;
            }else if(this.reco<o.reco) return -1;
            else return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rec = new int[101];
        ArrayList<Student> list = new ArrayList<>();
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++){
            int n = Integer.parseInt(st.nextToken());
            if(rec[n]>0){
                rec[n]+=1;
                for(int i=0; i<list.size(); i++){
                    if(list.get(i).num==n){
                        list.get(i).reco+=1;
                        break;
                    }
                }
            }else {
                if(list.size()>=N){
                    Collections.sort(list);
                    rec[list.get(0).num]=0;
                    list.remove(0);
                }
                list.add(new Student(n, 1, m));
                rec[n]=1;
            }
        }
        for(int i=0; i<101; i++){
            if(rec[i]!=0){
                System.out.print(i+" ");
            }
        }

    }
}
