package boj;

import java.util.Scanner;

public class Boj_5585_거스름돈 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int money = 1000 - input;               // 거스름돈 (잔돈)의 양
        int[] en = {500, 100, 50, 10, 5, 1};    // 엔화 배열 (내림차순)

        int ans = 0;                            // 정답 (최소 잔돈의 수)
        for(int i=0; i<en.length; i++) {        // 엔화를 큰 순서대로 모두 사용해보기
            ans += money/en[i];                 // 엔화를 사용한 개수를 잔돈에 더하기
            money %= en[i];                     // 남은 거스름돈
        }
        System.out.println(ans);

    }

}
