# :strawberry: 완전탐색

## :one: 완전탐색이란?
+ **가능한 방법을 전부 만들어보는 알고리즘**으로 **Brute-Force(무식하게풀기)알고리즘**이라고 불린다.
+ 컴퓨터의 빠른 계산 속도를 이용해 가능한 경우의 수를 모두 나열하면서 답을 찾는 방법 <br />
  => 일반적으로 경우의 수가 상대적으로 작을 때 유용
+ 주어진 문제를 풀 때, **우선 완전탐색으로 접근하여 해답을 도출한 후**, <br />
  성능 개선을 위해 다른 알고리즘을 사용하여 해답을 확인하는 것이 바람직하다.

## :two: 완전탐색 방법
1. Brute-Force
2. 순열, 조합, 부분집합
3. 비트마스크
4. 백트랙킹
5. BFS/DFS

## :three: 완전탐색 이해하기
Baby-gin 게임으로 완전탐색을 이해해보자!

### 1) Baby-gin 게임이란?
+ 0~9 숫자 카드에서 임의의 카드 6장을 뽑았을 때 3장의 카드가 연속적인 번호를 갖는 경우를 RUN 이라하고, 3장의 카드가 동일한 번호를 갖는 경우를 TRIPLE 라고 함.
+ 6장의 카드는 RUN, TRIPLE로 이루어져 있어야 Baby-gin이다.

### 2) 6개의 숫자가 입력되었을 때, Baby-gin인지 확인하는 알고리즘을 생각해보자.
1. 6개의 숫자로 만들 수 있는 모든 숫자를 나열한다. (6개의 숫자로 만드는 순열)
2. 각각의 경우에 대해서 Baby-gin인지 확인한다.

### 3) Counting 배열을 이용하여 Baby-gin문제 풀어보기
```java
public class BabyJin {
  
    public static void main(String[] args) {
        
       Scanner sc = new Scanner(System.in);
				
        // 1. 숫자를 저장할 배열 생성과 6개의 숫자 입력받기
        int[] arr = new int[6];
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
      
        // 2. 입력된 숫자의 개수를 세기위한 카운팅 배열 생성
        int[] cnt = new int[10];
        for(int i=0;i<arr.length;i++) {
            cnt[arr[i]]++; // cnt배열의 값이 arr에 입력된 숫자의 개수만큼 증가
        }
        
        // 3. 카운팅 배열을 이용해서 답 구하기
        for(int i=0;i<cnt.length;i++) { 

            // TRIPLE
            if(cnt[i]>=3) {
                System.out.println("TRIPLE");
                cnt[i]-=3;
            } 
            
            // RUN
            if(i-1>=0 && i+1<cnt.length) { // 범위체크
                if(cnt[i-1]>0 && cnt[i]>0 && cnt[i+1]>0) {
                    System.out.println("RUN");
                    cnt[i-1]--;
                    cnt[i]--;
                    cnt[i+1]--;
                }
            }
        }
        
        // 4. Baby-gin인지 아닌지 검사
      
        // 하나라도 사용하지않은 숫자가 있다면 Baby-gin이 아니므로 main함수 종료
        for(int i=0;i<cnt.length;i++) {
            if(cnt[i]!=0) return;
        }
        System.out.println("Baby-gin");
    }
  
}
```
