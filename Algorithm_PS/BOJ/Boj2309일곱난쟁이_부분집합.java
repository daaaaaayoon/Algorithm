package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2309일곱난쟁이_부분집합 {
	
	static int[] heights, ans;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		heights = new int[9];
		ans = new int[7];
		isSelected = new boolean[9];
		
		for(int i=0; i<9; i++) heights[i] = Integer.parseInt(br.readLine());
		
		find(0, 0, 0);
		// 선택된 일곱난쟁이들의 키를 ans배열에 담기
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
		
		// 선택
		isSelected[idx] = true;
		if(find(idx+1, cnt+1, sum+heights[idx])) return true; // 선택한 상황을 반영하여 다음으로 넘어감.
		// 비선택
		isSelected[idx] = false;
		return find(idx+1, cnt, sum); // 이 아래의 코드는 없으므로, 결과값 바로 리턴 가능.
	}
}
