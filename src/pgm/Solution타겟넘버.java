package pgm;

public class Solution타겟넘버 {

    static int answer;

    static int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }

    private static void dfs(int cnt, int sum, int[] numbers, int target) {
        if(cnt == numbers.length){
            if(sum == target) answer++;
            return;
        }
        dfs(cnt+1, sum+numbers[cnt], numbers, target);
        dfs(cnt+1, sum-numbers[cnt], numbers, target);
    }

}