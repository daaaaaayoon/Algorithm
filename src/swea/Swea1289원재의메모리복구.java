package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea1289원재의메모리복구 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			int ans = 0;
			char[] memory = br.readLine().toCharArray();

			char now = '0';
			for (int i = 0; i < memory.length; i++) {
				if (memory[i] != now) {
					ans++;
					now = memory[i];
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
