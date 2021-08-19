package algo_202108;

public class Boj_6679_싱기한네자리숫자 {

    public static void main(String[] args) {

        for(int i=1000; i<=9999; i++) {

            int sum10 = 0;
            int sum12 = 0;
            int sum16 = 0;

            for(int n=i; n>0; n/=10) {
                sum10+=n%10;
            }

            for(int n=i; n>0; n/=12) {
                sum12+=n%12;
            }

            for(int n=i; n>0; n/=16) {
                sum16+=n%16;
            }

            if(sum10==sum12 && sum12==sum16) System.out.println(i);
        }

    }

}
