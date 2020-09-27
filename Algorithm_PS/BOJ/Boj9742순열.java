package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9742순열 {
	
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
			ans = new char[len]; // 순열 처리 결과를 담을 배열
			isSelected = new boolean[len];
			total = 0; // 순열 처리횟수를 저장할 변수
			
			// factorial로 미리 그 값에 도달이 가능한지를 검사함.
			// len개의 문자로 만들 수 있는 순열의 경우의 수 : len!
			int i = len;
			int fac = 1;
			while(i > 0) {
				fac *= i;
				i--;
			}
			
			System.out.print(line+" = ");
			// 순열 불가능
			if(fac < n) { // 만들수 있는 경우의 수보다 넘는 순번을 제시하면 계산하지않고 NO출력
				System.out.println("No permutation");
			}else { // 순열 가능
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
