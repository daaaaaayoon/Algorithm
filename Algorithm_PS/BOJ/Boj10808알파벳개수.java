package BOJ;

import java.util.Scanner;

public class Boj10808���ĺ����� {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		// ���ĺ��� ������ ���� �迭
		int[] alphabet = new int[26];
		
		// �ҹ��� 'a'�� 97�̶�� ����
		for(int i=0; i<input.length(); i++) {
			alphabet[input.charAt(i)-97]++;
		}
		
		// ���
		for(int i : alphabet) {
			System.out.print(i+" ");
		}
	}
	
}
