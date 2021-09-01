package pgm;

import java.util.Arrays;

public class Solution완주하지못한선수_listsort {

    public static void main(String[] args) {

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));

    }

    static String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i<completion.length; i++) {
            if(!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }

        return participant[participant.length-1];

    }

}
