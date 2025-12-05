class Solution {
    public String solution(String new_id) {

        // 1단계: 소문자로 변환
        new_id = new_id.toLowerCase();

        // 2단계: 허용된 문자만 남기기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);

            // 소문자
            if (c >= 'a' && c <= 'z') sb.append(c);
            // 숫자
            else if (c >= '0' && c <= '9') sb.append(c);
            // 허용 특수문자
            else if (c == '-' || c == '_' || c == '.') sb.append(c);
            // 그 외는 버림
        }
        String s = sb.toString();

        // 3단계: 마침표 연속 → 하나로
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 연속된 .이면 하나만 넣기
            if (c == '.') {
                if (sb2.length() == 0 || sb2.charAt(sb2.length() - 1) != '.') {
                    sb2.append(c);
                }
            } else {
                sb2.append(c);
            }
        }
        s = sb2.toString();

        // 4단계: 앞뒤의 . 제거
        if (s.startsWith(".")) {
            s = s.substring(1);
        }
        if (s.endsWith(".")) {
            s = s.substring(0, s.length() - 1);
        }

        // 5단계: 빈 문자열이면 "a"
        if (s.isEmpty()) {
            s = "a";
        }

        // 6단계: 16자 이상이면 15자까지만 → 끝 . 제거
        if (s.length() >= 16) {
            s = s.substring(0, 15);
        }
        if (s.endsWith(".")) {
            s = s.substring(0, s.length() - 1);
        }

        // 7단계: 2자 이하라면 마지막 문자 반복
        while (s.length() < 3) {
            s += s.charAt(s.length() - 1);
        }

        return s;
    }
}