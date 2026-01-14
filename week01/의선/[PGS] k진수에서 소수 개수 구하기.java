package week1;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        // k진수 변환
        String num = "";
        while (n != 0) {
            int temp = n % k;
            n /= k;
            num = temp + num;
        }

        // 0 기준 분리
        String[] box = num.split("0");

        for (String s : box) {
            if (s.isEmpty()) continue;       // 빈 문자열 방지
            long val = Long.parseLong(s);
            if (isPrime(val)) answer++;
        }

        return answer;
    }

    static boolean isPrime(long x) {
        if (x < 2) return false;
        if (x % 2 == 0) return x == 2;
        for (long i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }
}