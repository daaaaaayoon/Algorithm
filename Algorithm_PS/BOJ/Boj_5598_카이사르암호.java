package boj_202107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_5598_카이사르암호 {

    public static void main(String[] args) throws IOException {

        // 카이사르 암호를 입력받는다. (입력되는 단어는 최대 1000자)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] caesar = br.readLine().toCharArray();

        // 입력된 암호를 원래 문자로 돌려놓는다.
        for(int i=0; i<caesar.length; i++) {

            if(caesar[i]-3 < 65) {
                caesar[i] += 23;
                continue;
            }

            caesar[i] -= 3;

        }

        // 원래 문자를 출력한다.
        for(char c : caesar) {
            System.out.print(c);
        }

    }

}
