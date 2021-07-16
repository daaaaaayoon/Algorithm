package algo_202107.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1966_프린터큐 {

    static ArrayList<Paper> queue;
    static class Paper {
        int idx, imp;
        Paper(int idx, int imp) {
            this.idx = idx;
            this.imp = imp;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            queue = new ArrayList<>();
            for(int n=0; n<N; n++) {
                queue.add(new Paper(n, Integer.parseInt(st.nextToken())));
            }

            System.out.println(solve(N, X));

        }

    }

    private static int solve(int N, int X) {

        int order = 1;
        while(!queue.isEmpty()) {

            boolean back = false;
            Paper first = queue.get(0);
            for(int s=1; s<queue.size(); s++) {
                if(queue.get(s).imp > first.imp) back = true;
            }
            if(back) {
                queue.remove(first);
                queue.add(first);
            }else {
                if(first.idx == X) {
                    // order 출력
                    return order;
                }
                queue.remove(first);
                ++order;
            }

        }
        return order;

    }

}
