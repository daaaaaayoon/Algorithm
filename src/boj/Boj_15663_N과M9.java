package boj;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Boj_15663_N과M9 {
	
	static int N, M;
	static int[] input;
	static int[] ans;
	static boolean[] used;
	static Set<String> set;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		input = new int[N];
		ans = new int[M];
		used = new boolean[N];
		set = new LinkedHashSet<>();
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		Arrays.sort(input);
		
		perm(0);
		
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	static void perm(int cnt) {
		if(cnt == M) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; i++) {
				sb.append(ans[i]+" ");
			}
			set.add(sb.toString());
			return;
		}
		for(int i=0; i<N; i++) {
			if(!used[i]) {
				used[i] = true;
				ans[cnt] = input[i];
				perm(cnt+1);
				used[i] = false;
			}
		}
	}
}
