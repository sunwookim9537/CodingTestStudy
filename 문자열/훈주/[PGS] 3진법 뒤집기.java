class Solution {
    public int solution(int n) {

        // 1) 10진수 → 3진수
        String ternary = Integer.toString(n, 3);

        // 2) 3진수 문자열 뒤집기
        String reversed = new StringBuilder(ternary).reverse().toString();

        // 3) 3진수 → 10진수
        int result = Integer.parseInt(reversed, 3);

        return result;
    }
}

/*
class Solution {
    public int solution(int n) {

        // 1) 10진수 → 3진수 문자열 변환 (직접 계산)
        String ternary = "";
        while (n > 0) {
            int r = n % 3;       // 3으로 나눈 나머지가 자리수
            ternary = r + ternary;  // 앞에 붙인다
            n = n / 3;
        }

        // 2) 문자열 뒤집기
        String reversed = "";
        for (int i = ternary.length() - 1; i >= 0; i--) {
            reversed += ternary.charAt(i);
        }

        // 3) 뒤집힌 3진수를 10진수로 변환 (직접 계산)
        int result = 0;
        int power = 1; // 3^0부터 시작

        for (int i = reversed.length() - 1; i >= 0; i--) {
            int digit = reversed.charAt(i) - '0'; // 문자→숫자
            result += digit * power;
            power *= 3;
        }

        return result;
    }
}
*/