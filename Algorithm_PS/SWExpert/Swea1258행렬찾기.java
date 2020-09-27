package SWEA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Swea1258���ã�� {
	
	static int N;
	static int[][] container;
	static boolean[][] visit;
	static ArrayList<Matrix> arr;
	
	static class Matrix implements Comparable<Matrix>{
		int r; int c; int size; // ���� ����, ���� ����, ������(��*��)
		Matrix(int r, int c, int size){
			this.r = r;
			this.c = c;
			this.size = size;
		}
		
		@Override
		public int compareTo(Matrix o) {
			if(this.size == o.size) // ����� ���ٸ�
				return this.r - o.r; // ���� ���� �������
			return this.size - o.size; // ����� �ٸ��ٸ�, ����� ���� �������
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			N = sc.nextInt();
			
			container = new int[N][N];
			visit = new boolean[N][N];
			arr = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					container[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visit[i][j] && container[i][j]!=0) {
						
						int rowCnt = 0, row = i, colCnt = 0, col = j;
						
						while(row<N && container[row][j]!=0) {
							
							colCnt = 0; col = j;
							while(col<N && container[row][col]!=0) {
								colCnt++;
								visit[row][col] = true;
								col++;
							}
							
							rowCnt++;
							row++;
						}
						arr.add(new Matrix(rowCnt, colCnt, rowCnt*colCnt));
					}
				}
			}// for end
			
			Collections.sort(arr);
			
			System.out.print("#"+tc+" "+arr.size()+" ");
			for(Matrix m : arr) {
				System.out.print(m.r+" "+m.c+" ");
			}
			System.out.println();
		}// tc end
	}
}
