package pgm;

public class Solution카펫 {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        // i는 시도할 가로의 길이
        for(int i=3; i<total; i++){
            // i로 카펫을 못만드는 경우 또는 세로의 길이가 가로보다 큰 경우
            if(total%i!=0 || i<total/i) continue;
            if(yellow%(i-2)==0){
                answer[0] = i;
                answer[1] = total/i;
                return answer;
            }
        }
        return answer;
    }

}
