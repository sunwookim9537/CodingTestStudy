class Solution {
    private String convertToBase(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }

    private boolean isPrime(long num) {
        if (num <= 1) return false;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;

        String baseK = convertToBase(n, k);
        String[] parts = baseK.split("0");

        for (String part : parts) {
            if (part.equals("")) continue;

            long value = Long.parseLong(part);
            if (isPrime(value)) {
                answer++;
            }
        }

        return answer;
    }
}