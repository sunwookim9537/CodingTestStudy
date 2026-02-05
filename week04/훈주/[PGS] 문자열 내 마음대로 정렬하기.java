import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        // 제한조건: 모든 strings 원소 길이는 n보다 크다 => charAt(n) 안전
        // 원본 배열을 그대로 정렬해도 되지만, 문제 습관상 복사해도 좋음
        String[] answer = Arrays.copyOf(strings, strings.length);

        Arrays.sort(answer, (a, b) -> {
            char ca = a.charAt(n);
            char cb = b.charAt(n);

            // 1) n번째 문자로 우선 비교
            if (ca != cb) {
                return ca - cb; // 오름차순
            }

            // 2) n번째 문자가 같으면 전체 문자열 사전순 비교
            return a.compareTo(b);
        });

        return answer;
    }
}