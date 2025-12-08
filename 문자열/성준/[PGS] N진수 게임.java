/*
     n 2진수 (이해된거 같음) or 16 진수 (이건 뭔데 0~F 까지 해서 구하라고?)
     char[] digits = "0123456789ABCDEF".toCharArray(); String temp = ""; while (num > 0) { temp += digits[num % n];
     // n진법 나머지 num /= n; } temp = new StringBuilder(temp).reverse().toString(); 일단 이렇게 하라는거잖아....
     그리고 t까지로 돌리면 되는거 아닌가?
      */
    static class Solution {
        public String solution(int n, int t, int m, int p) {
            char[] digits = "0123456789ABCDEF".toCharArray();

            // n진수 변환 함수
            java.util.function.IntFunction<String> convert = (num) -> {
                if (num == 0) return "0";
                StringBuilder sb = new StringBuilder();
                int temp = num;
                while (temp > 0) {
                    sb.append(digits[temp % n]);
                    temp /= n;
                }
                return sb.reverse().toString();
            };

            // 전체 숫자 이어붙이기
            StringBuilder total = new StringBuilder();
            int num = 0;
            while (total.length() < t * m) {
                total.append(convert.apply(num));
                num++;
            }

            // 튜브가 말해야 하는 문자만 추출
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < t; i++) {
                answer.append(total.charAt(i * m + (p - 1)));
            }

            return answer.toString();
        }
    }