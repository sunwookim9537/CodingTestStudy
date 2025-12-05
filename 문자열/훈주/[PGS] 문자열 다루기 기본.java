class Solution {
    public boolean solution(String s) {

        // 1. 길이 체크
        int len = s.length();
        if (!(len == 4 || len == 6)) {
            return false;
        }

        // 2. 숫자 여부 체크
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            // '0' ~ '9' 범위를 벗어나면 숫자가 아니다
            if (c < '0' || c > '9') {
                return false;
            }
        }

        // 3. 모든 문자가 숫자라면 true
        return true;
    }
}