package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2941크로아티아알파벳 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		int cnt = 0; // 알파벳을 세는 변수
		for(int i=0; i<line.length(); i++) {
			cnt++;
			switch(line.charAt(i)) {
			case 'c': 
				// i가 범위를 넘어가면 안되므로 처리해야함!! -> 아니면 런타임 에러
				if(i<line.length()-1 && (line.charAt(i+1)=='=' || line.charAt(i+1)=='-')) {
					i++;
				}
				break;
			case 'd':
				if(i <line.length()-2 && line.charAt(i+1)=='z' && line.charAt(i+2)=='=') { 
					i+=2;
				}else if(i <line.length()-1 && line.charAt(i+1)=='-') {
					i++;
				}
				break;
			case 'l':
				if(i<line.length()-1 && line.charAt(i+1)=='j') {
					i++;
				}
				break;
			case 'n':
				if(i<line.length()-1 && line.charAt(i+1)=='j') {
					i++;
				}
				break;
			case 's':
			case 'z':
				if(i<line.length()-1 && line.charAt(i+1)=='=') {
					i++;
				}
				break;
			}
		}
		System.out.println(cnt);
	}
}
