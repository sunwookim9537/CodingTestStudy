class Solution {
    public int[] solution(String s) {
        int count = 0;      // 변환 횟수
        int removed = 0;    // 제거된 0의 총합

        while (!s.equals("1")) {
            int before = s.length();         // 변경 전 길이
            s = s.replace("0", "");          // 0 제거
            int after = s.length();          // 변경 후 길이
            removed += (before - after);     // 제거된 0 더하기

            s = Integer.toBinaryString(after); // 길이를 2진수로 변환
            count++;                          // 회차 증가
        }

        return new int[]{count, removed};
    }
}