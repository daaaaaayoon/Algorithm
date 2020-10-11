package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// 노가다 is worth it,,,
public class Boj2037문자메세지 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// p : 버튼을 한번 누르는데 걸리는 시간
		int p = Integer.parseInt(st.nextToken());
		// w : 같은 숫자인 문자를 연속으로 찍기 위해 기다리는 시간
		int w = Integer.parseInt(st.nextToken());
		// 적을 문자열
		char[] strArr = br.readLine().toCharArray();
		
		int ans = 0;
		int beforeNum = 0;
		for(int i=0; i<strArr.length; i++) {
			
			switch(strArr[i]) {
			case ' ':
				ans += p;
				beforeNum = 1;
				break;
			case 'A': case 'B': case 'C':
				if(beforeNum == 2) ans += w;
				ans += (p*(strArr[i]-64));
				beforeNum = 2;
				break;
			case 'D': case 'E': case 'F':
				if(beforeNum == 3) ans += w;
				ans += (p*(strArr[i]-67));
				beforeNum = 3;
				break;
			case 'G': case 'H': case 'I':
				if(beforeNum == 4) ans += w;
				ans += (p*(strArr[i]-70));
				beforeNum = 4;
				break;
			case 'J': case 'K': case 'L':
				if(beforeNum == 5) ans += w;
				ans += (p*(strArr[i]-73));
				beforeNum = 5;
				break;
			case 'M': case 'N': case 'O':
				if(beforeNum == 6) ans += w;
				ans += (p*(strArr[i]-76));
				beforeNum = 6;
				break;
			case 'P': case 'Q': case 'R': case 'S':
				if(beforeNum == 7) ans += w;
				ans += (p*(strArr[i]-79));
				beforeNum = 7;
				break;
			case 'T': case 'U': case 'V':
				if(beforeNum == 8) ans += w;
				ans += (p*(strArr[i]-83));
				beforeNum = 8;
				break;
			case 'W': case 'X': case 'Y': case 'Z':
				if(beforeNum == 9) ans += w;
				ans += (p*(strArr[i]-86));
				beforeNum = 9;
				break;
			}
		}
		
		System.out.println(ans);
	}
}
