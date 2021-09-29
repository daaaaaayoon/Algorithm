package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_20055_컨베이어벨트위의로봇 {

    static int N, K;
    static ArrayList<Convey> belt;
    static class Convey{
        int dura;
        boolean robot;
        Convey(int dura, boolean robot){
            this.dura = dura; // 내구도
            this.robot = robot; // 로봇이 있는지의 여부
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*N; i++){
            belt.add(new Convey(Integer.parseInt(st.nextToken()), false));
        }
        int ans = 0;
        while(true){
            ans++;
            // 1. 로봇과 함께 벨트가 회전
            // 1-1. 2*N-1에 있는 칸을 맨 앞으로 옮긴다.
            Convey convey = belt.get(2*N-1);
            belt.remove(2*N-1);
            belt.add(0, convey);
            // 1-2. N번째 칸(나는 N-1)에 있는 로봇을 내린다
            belt.get(N-1).robot=false;
            // 2. 제일 오른쪽부터 회전방향으로 로봇을 한칸 이동한다. (이동하려는 칸의 내구도가 1이상이고 그 칸에 로봇이 없을 경우)
            for(int i=N-2; i>=0; i--){
                if(belt.get(i).robot && belt.get(i+1).dura>0 && !belt.get(i+1).robot){
                    belt.get(i).robot=false; // 로봇 이동
                    belt.get(i+1).robot=true;
                    belt.get(i+1).dura-=1; // 내구도 감소
                }
            }
            // N-1칸으로 옮겨진 로봇은 즉시 내린다
            belt.get(N-1).robot=false;
            // 3. 올리는 위치가 내구도 0이 아닌 경우 로봇을 올린다.
            if(belt.get(0).dura>0){
                belt.get(0).robot=true;
                belt.get(0).dura-=1;
            }
            // 4. 내구도 검사
            int cnt = 0;
            for(int i=0; i<2*N; i++){
                if(belt.get(i).dura==0){
                    cnt++;
                }
            }
            // 내구도가 K 이상인 경우 종료한다.
            if(cnt>=K) break;
        }
        System.out.println(ans);
    }

}
