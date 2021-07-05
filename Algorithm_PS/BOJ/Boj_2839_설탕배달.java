package boj_202107;

import java.util.Scanner;

public class Boj_2839_설탕배달 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = Integer.MAX_VALUE;

        // 전부 5킬로그램 봉지에 담을 수 있다면 그게 정답
        if(N%5 == 0) {
            System.out.println(N/5);
            return;
        }

        // 5킬로그램 봉지에 담을 수 있는 갯수 : 0개 ~ N/5개
        for(int i=0; i<=N/5; i++) {
            int r = N - (i*5); // i개의 5킬로그램 봉지를 쓰고 남은 설탕의 무게
            if(r%3 == 0) { // 남은 설탕의 양을 3킬로그램 봉지에 맞추어 담을 수 있다면
                ans = Math.min(ans, i+r/3); // 지금까지 나온 최솟값과 비교하여 갱신
            }
        }

        // 정확하게 봉지에 담지 못하는 경우는 ans 값이 갱신되지 않았음 : -1 출력
        System.out.println(ans != Integer.MAX_VALUE ? ans : -1);

    }

}
