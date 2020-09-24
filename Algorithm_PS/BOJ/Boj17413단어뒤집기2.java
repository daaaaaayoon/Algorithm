package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj17413단어뒤집기2 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		
		String line = br.readLine();
		
		for(int i=0; i<line.length(); i++) {
			
			if(line.charAt(i)=='<') {
				
				// 스택에 담겨있던 단어들 빼서 sb에 붙이기
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				
				sb.append('<');
				while(true) {
					
					
					++i;
					sb.append(line.charAt(i));
					if(line.charAt(i)=='>') {
						break;
					}
				}
			}else if(line.charAt(i)==' ') {
				
				// 스택에 담겨있던 단어들 빼서 sb에 붙이기
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				
				sb.append(' ');
			} else {
				stack.push(line.charAt(i));
			}
			
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.toString());
	}
	
}
