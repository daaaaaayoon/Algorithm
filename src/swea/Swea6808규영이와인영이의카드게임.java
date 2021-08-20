package swea;

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
			kyu = new int[9];
			een = new int[9];
			eenPerm = new int[9];
			eenSelected = new boolean[9];
			
			for(int i=0; i<9; i++) {
				int n = sc.nextInt();
				card[n] = 1;
			}
			
			int cntk = 0, cnte = 0;
			for(int i=1; i<19; i++) {
				if(card[i]==1) {
					kyu[cntk++] = i;
				} else {
					een[cnte++] = i;
				}
			}
			
			perm(0);
			
			System.out.println("#"+tc+" "+win+" "+lose);
		}
	}
	
	static void perm(int cnt) {
		if(cnt == 9) {
			int totalKyu = 0, totalEen = 0;
			for(int i=0; i<9; i++) {
				if(kyu[i] > eenPerm[i]) {
					totalKyu += (kyu[i]+eenPerm[i]);
				} else if(kyu[i] < eenPerm[i]) {
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
