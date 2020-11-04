package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 처음에 연쇄적으로 회전한다는 것을 안했었음 => 문제 제대로 파악하기!!!
public class Boj14891톱니바퀴 {
	
	static int[][] input;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		input = new int[5][8];
		for(int i=1; i<=4; i++) {
			String line = br.readLine();
			for(int j=0; j<8; j++) {
				input[i][j] = line.charAt(j)-'0';
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			visit = new boolean[5];
			
			check(num, dir);
			
		}
		
		int ans =0;
		for(int i=1; i<=4; i++) {
			ans += input[i][0]*(1<<(i-1));
		}
		System.out.println(ans);
	}
	
	static void check(int num, int dir) {
		
		visit[num] = true;
		
		// 왼쪽
		if(num-1>0 && !visit[num-1] && input[num][6]!=input[num-1][2]) {
			if(dir==-1) check(num-1, dir+2);
			else check(num-1, dir-2);
		}
		
		// 오른쪽
		if(num+1<5 && !visit[num+1] && input[num][2]!=input[num+1][6]) {
			if(dir==-1) check(num+1, dir+2);
			else check(num+1, dir-2);
		}
		
		// 자신
		push(num, dir);
	}
	
	static void push(int num, int dir) {
		// 반시계방향
		if(dir == -1) {
			int tmp = input[num][0];
			for(int i=0; i<=6; i++) {
				input[num][i] = input[num][i+1];
			}
			input[num][7] = tmp;
		}else { // 시계방향
			int tmp = input[num][7];
			for(int i=7; i>=1; i--) {
				input[num][i] = input[num][i-1];
			}
			input[num][0] = tmp;
		}
	}
	
}