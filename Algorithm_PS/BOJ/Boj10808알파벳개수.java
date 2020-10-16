package BOJ;

import java.util.Scanner;

public class Boj10808알파벳개수 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		// 알파벳의 개수를 담을 배열
		int[] alphabet = new int[26];
		
		// 소문자 'a'는 97이라는 숫자
		for(int i=0; i<input.length(); i++) {
			alphabet[input.charAt(i)-97]++;
		}
		
		// 출력
		for(int i : alphabet) {
			System.out.print(i+" ");
		}
	}
	
}
