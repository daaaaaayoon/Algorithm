package pgm;

import java.util.Arrays;
import java.util.HashMap;

public class Solution전화번호목록 {

    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        HashMap<String, String> map = new HashMap<>();
        for(String s: phoneBook){
            map.put(s, s);
        }
        for(String s: phoneBook){
            for(int idx=1; idx<s.length(); idx++){
                String tmp = s.substring(0, idx);
                if(map.containsKey(tmp)){
                    return false;
                }
            }
        }
        return true;
    }

}
