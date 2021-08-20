package boj;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Boj_15665_N과M11 {
	
	static int N, M;
	static int[] input;
	static int[] ans;
	static Set<String> set;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		input = new int[N];
		ans = new int[M];
		set = new LinkedHashSet<String>();
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		Arrays.sort(input);
		perm(0);
		
		Iterator<String> it = set.iterator();
		
		sb = new StringBuilder();
		while(it.hasNext()) {
			sb.append(it.next()+"\n");
		}
		System.out.println(sb.toString());
	}
	
	static void perm(int cnt) {
		if(cnt == M) {
			sb = new StringBuilder();
			for(int i=0; i<M; i++) {
				sb.append(ans[i]+" ");
			}
			set.add(sb.toString());
			return;
		}
		for(int i=0; i<N; i++) {
			ans[cnt] = input[i];
			perm(cnt+1);
		}
	}
}
