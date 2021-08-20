package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2309_일곱난쟁이_부분집합 {
	
	static int[] heights, ans;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		heights = new int[9];
		ans = new int[7];
		isSelected = new boolean[9];
		
		for(int i=0; i<9; i++) heights[i] = Integer.parseInt(br.readLine());
		
		find(0, 0, 0);

		for(int i=0,j=0; i<9; i++) {
			if(isSelected[i]) ans[j++] = heights[i];
		}
		
		Arrays.sort(ans);
		for(int a : ans) {
			System.out.println(a);
		}
	}
	
	static boolean find(int idx, int cnt, int sum) {
		if(cnt == 7 && sum == 100) return true;
		if(cnt == 7 || idx == 9 || sum > 100) return false;
		
		isSelected[idx] = true;
		if(find(idx+1, cnt+1, sum+heights[idx])) return true;
		isSelected[idx] = false;
		return find(idx+1, cnt, sum);
	}
}
