class Solution {
    public int solution(String s) {

        // 0~9에 대응하는 영단어
        String[] words = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
        };

        // 영단어를 숫자로 치환
        for (int i = 0; i < words.length; i++) {
            // words[i] = "one"
            // i = 1 → 숫자 1
            s = s.replace(words[i], String.valueOf(i));
        }

        // 최종 변환된 문자열을 정수로 바꿔서 리턴
        return Integer.parseInt(s);
    }
}