package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_11060_점프점프 {

    static int N, ans;
    static int[] maze;
    static boolean[] visit;
    static Queue<Point> queue;

    static class Point {
        int i, jump;
        Point(int i, int jump) {
            this.i = i;
            this.jump = jump;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ans = Integer.MAX_VALUE;
        maze = new int[N];
        visit = new boolean[N];
        queue = new LinkedList<>();

        for(int n=0; n<N; n++) {
            maze[n] = sc.nextInt();
        }

        if(N==1) {
            System.out.println(0);
            return;
        }

        // 1) 왼쪽칸을 큐에 넣는다.
        visit[0] = true;
        queue.add(new Point(0, 0));

        // 2) bfs 시작 : 점프 수 누적하기
        bfs();

        // 3) 오른쪽 끝에 도달한 경우 정답, 아닌 경우 -1 출력
        System.out.println(ans==Integer.MAX_VALUE ? -1 : ans);

    }

    private static void bfs() {

        while(!queue.isEmpty()) {

            Point p = queue.poll();

            for(int j=p.i+1; j<=p.i+maze[p.i]; j++) {

                if(j >= N) continue;
                if(j == N-1) {
                    ans = p.jump + 1;
                    return;
                }
                if(!visit[j]) {
                    visit[j] = true;
                    queue.add(new Point(j, p.jump+1));
                }

            }

        }

    }

}
