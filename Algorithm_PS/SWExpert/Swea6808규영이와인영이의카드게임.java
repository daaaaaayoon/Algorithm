package SWEA;

import java.util.Scanner;

public class Swea6808규영이와인영이의카드게임 {
	
	static int[] card;
	static int[] kyu;
	static int[] een;
	static int[] eenPerm;
	static boolean[] eenSelected;
	static int win, lose;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			
			win = 0; lose = 0;
			card = new int[19];
			kyu = new int[9]; // 규영이의 카드
			een = new int[9]; // 인영이의 카드
			eenPerm = new int[9]; // 인영이 카드의 순열이 만들어져 저장될 배열
			eenSelected = new boolean[9];
			
			for(int i=0; i<9; i++) {
				int n = sc.nextInt();
				card[n] = 1; // 규영이의 카드는 1로 표시
			}
			
			// 규영이와 인영이의 카드 배열을 만든다.
			int cntk = 0, cnte = 0;
			for(int i=1; i<19; i++) {
				if(card[i]==1) {
					kyu[cntk++] = i;
				} else {
					een[cnte++] = i;
				}
			}
			
			// 인영이의 카드로 순열을 만들기위해 재귀함수 호출.
			perm(0);
			
			System.out.println("#"+tc+" "+win+" "+lose);
		}
	}
	
	static void perm(int cnt) {
		if(cnt == 9) { // 인영이의 카드로 순열을 모두 만들었다면
			
			int totalKyu = 0, totalEen = 0;
			for(int i=0; i<9; i++) {
				if(kyu[i] > eenPerm[i]) { // 규영이의 카드가 큰 경우
					totalKyu += (kyu[i]+eenPerm[i]);
				} else if(kyu[i] < eenPerm[i]) { // 인영이의 카드가 큰 경우
					totalEen += (kyu[i]+eenPerm[i]);
				}
			}
			
			if(totalKyu > totalEen) {
				win++;
			}else if(totalKyu < totalEen) {
				lose++;
			}
			
			return;
		}
		for(int i=0; i<9; i++) {
			if(eenSelected[i]) continue;
			eenSelected[i] = true;
			eenPerm[cnt] = een[i];
			perm(cnt+1);
			eenSelected[i] = false;
		}
	}

}
