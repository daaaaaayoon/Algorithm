package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2309_일곱난쟁이_조합 {
	
	static int[] heights, ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		heights = new int[9];
		ans = new int[7];
		
		for(int i=0; i<9; i++) heights[i] = Integer.parseInt(br.readLine());
		
		find(0, 0, 0);
		
		Arrays.sort(ans);
		for(int a : ans) {
			System.out.println(a);
		}
	}
	
	static boolean find(int start, int cnt, int sum) {
		if(cnt == 7 && sum == 100) return true;
		if(cnt == 7 || start == 9 || sum > 100) return false;
		
		for(int i=start; i<9; i++) {
			ans[cnt] = heights[i];
			if(find(i+1, cnt+1, sum+heights[i])) return true;
		}
		return false;
	}
}
