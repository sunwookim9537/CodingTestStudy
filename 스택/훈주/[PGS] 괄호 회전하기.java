import java.util.Stack;

class Solution {
    public int solution(String s) {
        int n = s.length();
        int count = 0;

        // i = 0 ~ n-1 회전 시작점(shift)을 의미
        // i=0이면 원본 그대로, i=1이면 왼쪽 1칸 회전 효과
        for (int shift = 0; shift < n; shift++) {
            if (isValidWithShift(s, shift)) {
                count++;
            }
        }
        return count;
    }

    // 실제로 문자열을 만들지 않고,
    // s.charAt((shift + idx) % n)로 "회전된 문자열의 idx번째 문자"를 읽는다.
    private boolean isValidWithShift(String s, int shift) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        // 회전된 문자열을 idx=0부터 끝까지 읽는다고 가정
        for (int idx = 0; idx < n; idx++) {

            // 회전된 상태에서 idx번째 문자는 원본에서 (shift + idx) % n 위치
            char c = s.charAt((shift + idx) % n);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if (!isMatch(open, c)) return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatch(char open, char close) {
        return (open == '(' && close == ')')
            || (open == '[' && close == ']')
            || (open == '{' && close == '}');
    }
}