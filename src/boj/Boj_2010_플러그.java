package boj;

import java.util.Scanner;

public class Boj_2010_플러그 {

    static int N;
    static int[] multitap;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        multitap = new int[N];
        for(int n=0; n<N; n++) {
            multitap[n] = sc.nextInt();
        }

        System.out.println(maxComputer());

    }

    private static int maxComputer() {

        int ans = multitap[0];

        for(int n=1; n<N; n++) {
            ans -= 1;
            ans += multitap[n];
        }

        return ans;

    }

}
