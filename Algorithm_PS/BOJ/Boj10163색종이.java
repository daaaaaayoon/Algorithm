package BOJ;

import java.util.Scanner;

public class Boj10163색종이 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] paper = new int[101][101];
		
		// 각각 입력받은 색종이에 번호 매기기 -> 이후에 입력된 숫자로 덮어 씌워지게됨
		for(int n=1; n<=N; n++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();
			
			for(int i=x; i<(x+width); i++) {
				for(int j=y; j<(y+height); j++) {
					paper[i][j] = n;
				}
			}
		}
		
		// 도화지에 번호들을 각각 세어서 출력한다.
		for(int n=1; n<=N; n++) {
			
			int cnt = 0;
			for(int i=0; i<=100; i++) {
				for(int j=0; j<=100; j++) {
					if(paper[i][j]==n) cnt++;
				}
			}
			System.out.println(cnt);
			
		}
	}
}
