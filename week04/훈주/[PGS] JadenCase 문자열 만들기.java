class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s.length());

        // 단어 시작인지 여부 (처음은 단어 시작으로 취급)
        boolean isStartOfWord = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                // 공백은 그대로 유지 (연속 공백도 유지)
                sb.append(ch);
                // 공백 다음 문자는 단어의 시작 후보가 됨
                isStartOfWord = true;
            } else {
                if (isStartOfWord) {
                    // 첫 문자가 알파벳이면 대문자, 숫자면 그대로
                    if (ch >= 'a' && ch <= 'z') {
                        sb.append((char) (ch - ('a' - 'A')));
                    } else {
                        sb.append(ch);
                    }
                    isStartOfWord = false;
                } else {
                    // 단어 중간은 알파벳이면 소문자
                    if (ch >= 'A' && ch <= 'Z') {
                        sb.append((char) (ch + ('a' - 'A')));
                    } else {
                        sb.append(ch);
                    }
                }
            }
        }

        return sb.toString();
    }
}