package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9742_순열 {
	
	static int n, len, total;
	static char[] chArr;
	static char[] ans;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String line = null;
		while((line = br.readLine()) != null) {
			
			st = new StringTokenizer(line);
			chArr = st.nextToken().toCharArray();
			n = Integer.parseInt(st.nextToken());
			len = chArr.length;
			ans = new char[len];
			isSelected = new boolean[len];
			total = 0;

			int i = len;
			int fac = 1;
			while(i > 0) {
				fac *= i;
				i--;
			}
			
			System.out.print(line+" = ");
			if(fac < n) {
				System.out.println("No permutation");
			}else {
				perm(0);
				for(char c : ans) {
					System.out.print(c);
				}
				System.out.println();
			}
		}// while end
	}
	
	static boolean perm(int cnt) {
		
		if(cnt == len) {
			total++;
			if(total == n) return true;
			return false;
		}
		for(int i=0; i<len; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				ans[cnt] = chArr[i];
				if(perm(cnt+1)) return true;
				isSelected[i] = false;
			}
		}
		return false;
	}
}
