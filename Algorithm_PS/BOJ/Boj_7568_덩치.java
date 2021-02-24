package Boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_7568_µ¢Ä¡ {
	
	static class Student{
		int x, y;
		Student(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] ans = new int[N];
		ArrayList<Student> studentList = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			studentList.add(new Student(x, y));
		}
		
		for(int i=0; i<N; i++) {
			
			int rank = 0;
			Student a = studentList.get(i);
			
			for(int j=0; j<N; j++) {
				if(i == j) continue;
				Student b = studentList.get(j);
				if(a.x < b.x && a.y < b.y) ++rank;
			}
			
			ans[i] = rank + 1;
			
		}
		
		for(int a : ans) {
			System.out.print(a+" ");
		}
		
	}
	
}
