package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11050이항계수1_factorial {
	
	static int N, K;
	static long[] memo; // 팩토리얼 값을 메모하는 배열
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		memo = new long[N+1];
		memo[0] = 1;
		memo[1] = 1;
		// nCk = n!/ k!(n-k)!
		long ans = fac(N)/(fac(N-K)*fac(K));
		
		System.out.println(ans);
		
	}
	
	static long fac(int n) {
		if(memo[n]==0 && n>=2) { // 메모된 값이 없고, n이 2이상일 때
			memo[n] = n * fac(n-1);
		}
		return memo[n];
	}
	
}
