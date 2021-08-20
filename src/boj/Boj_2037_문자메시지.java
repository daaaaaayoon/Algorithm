package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2037_문자메시지 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
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
