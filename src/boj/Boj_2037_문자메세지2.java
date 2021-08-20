package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2037_문자메세지2 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		char[] strArr = br.readLine().toCharArray();
		
		char[] number = {
				2, 2, 2,	// ABC
				3, 3, 3,	// DEF
				4, 4, 4,	// GHI
				5, 5, 5,	// JKL
				6, 6, 6,	// MNO
				7, 7, 7, 7,	// PQRS
				8, 8, 8,	// TUV
				9, 9, 9, 9	// WXYZ
			};
		char[] press = {
				1, 2, 3,	// ABC
				1, 2, 3,	// DEF
				1, 2, 3,	// GHI
				1, 2, 3,	// JKL
				1, 2, 3,	// MNO
				1, 2, 3, 4,	// PQRS
				1, 2, 3,	// TUV
				1, 2, 3, 4	// WXYZ
			};
		
		int ans = 0;
		for(int i=0; i<strArr.length; i++) {
			if(i>0) {
				if(strArr[i] == ' ') {
					ans += p;
					continue;
				}
			}
			if(i>0 && strArr[i-1] != ' ' && number[strArr[i]-'A'] == number[strArr[i-1]-'A']) {
					ans += w;
			}
			if(i>0 && strArr[i-1] == ' ') {
				ans += press[strArr[i]-'A']*p;
				continue;
			}
			ans += press[strArr[i]-'A']*p;
		}
		
		System.out.println(ans);
	}
}
