import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";

        if (isValid(p))
            answer = p;
        else
            answer = makeString(p);

        return answer;
    }

    private String makeString(String w) {
        String result = "";

        if (w.isBlank() || w == null || w.equals(""))
            return result;

        String[] uv = new String[2];

        parentheses(w, uv);
        String u = uv[0];
        String v = uv[1];

        StringBuilder sb = new StringBuilder();

        if (isValid(u)) {
            v = makeString(v);
            result = u + v;
        } else {
            sb.append("(");
            sb.append(makeString(v));
            sb.append(")");

            u = u.substring(1, u.length() - 1);
            u = reverseBraket(u);
            sb.append(u);

            result = sb.toString();
        }

        return result;
    }

    // 괄호 방향 바꾸어서 리턴
    private String reverseBraket(String str) {
        if (str.equals(""))
            return "";

        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (ch == ')')
                sb.append('(');
            else
                sb.append(')');
        }

        return sb.toString();
    }

    // str을 균형잡힌 문자열 u, v로 나누어서 result에 차례로 저장
    private boolean parentheses(String str, String[] result) {

        // 빈 문자열인 경우
        if (str.isBlank())
            return false;

        // split
        int leftBrk = 0;
        int rightBrk = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                leftBrk++;
            else if (str.charAt(i) == ')')
                rightBrk++;

            if (leftBrk == rightBrk) {
                result[0] = str.substring(0, i + 1);
                result[1] = str.substring(i + 1);

                return true;
            }
        }

        return false;
    }

    // 문자열이 올바른 괄호 문자열인지 검사
    private boolean isValid(String str) {

        if (str.isBlank())
            return true;

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(')
                stack.push('(');
            else if (ch == ')') {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }

        if (stack.isEmpty())
            return true;

        return false;
    }
}