package pgm;

public class Solution로또의최고순위와최저순위 {

    public static void main(String[] args) {

        int[] lottos = {1, 2, 3, 4, 5, 6};
        int[] win = {38, 19, 20, 40, 15, 25};
        int[] solution = solution(lottos, win);
        for(int i : solution){
            System.out.print(i+" ");
        }

    }

    static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        // 다 다른 번호가 주어질 것이라는 보장은?
        int hit=0; int zero=0;
        for(int i=0; i<lottos.length; i++){
            if(lottos[i]==0){
                zero++;
                continue;
            }
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i]==win_nums[j]){
                    hit++;
                }
            }
        }

        answer[0]=(hit+zero==0)?6:7-(hit+zero);
        answer[1]=(hit<=1)?6:7-hit;
        return answer;
    }

}
