package studycodingtest.week;
/*
    와...생각도 못한곳에서 시간 끌음 String nTok = Integer.toString(n,k)함
    long 써야 하는 이유
    n = 1,000,000  k = 2   => 11110100001001000000(2진수) 이런건 되는데
    "11111111111111111111"  (20자리) 이따구로 나오면 Integer.MAX_VALUE = 2,147,483,647 이렇게 나온다고 함...

 */
public class week01_2 {
    public static void main(String[] args) {
        class Solution {
            public int solution(int n, int k) {
                int count = 0;

                // n을 k 진수로 변환
                String nTok = Long.toString(n, k);

                // 0 기준으로 분리
                String[] parts = nTok.split("0");

                // 0으로 생긴 빈 문자열 날려
                for (String s : parts) {
                    // 빈문자열이면 넘어가
                    if (s.equals("")) continue;


                    // 문자열 10진수로
                    long value = Long.parseLong(s);
                    if (isPrime(value)) {
                        count++;
                    }
                }

                return count;
            }

            private boolean isPrime(long num) {
                if (num < 2) return false; // 0,1 은 소수 아님

                for (long i = 2; i * i <= num; i++) {
                    if (num % i == 0) return false;
                }
                return true;
            }
        }
    }
}
