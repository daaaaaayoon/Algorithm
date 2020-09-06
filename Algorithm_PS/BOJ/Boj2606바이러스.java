package BOJ;

import java.util.Scanner;

public class Boj2606바이러스 {
	
	static int N, M;
	static int[] p;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		p = new int[N+1]; // 1~N까지 사용
		
		make();
		
		for(int m=0; m<M; m++) {
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			union(c1,c2);
		}
		
		int ans=0;
		for(int i=2; i<=N; i++) {
			if(find(i) == find(1)) ans++;
		}
		
		System.out.println(ans);
	}
	
	static void make() {
		for(int i=1; i<=N; i++) {
			p[i] = i;
		}
	}
	
	static int find(int a) {
		if(p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) {
			p[bRoot] = aRoot;
			return;
		}
		return;
	}
}
