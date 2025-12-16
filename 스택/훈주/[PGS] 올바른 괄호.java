class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int count = 0;    // 현재까지 열렸지만 아직 닫히지 않은 '(' 개수
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '('){ //'(' → 열린 괄호 하나 증가
                count++;
            }
            if(s.charAt(i) == ')'){ //')' → 열린 괄호 하나를 닫음
                count--;
            }
            if(count < 0){ //')'가 먼저 나온 상황->실패
                break;
            }
        }
        if(count == 0){ //모든 괄호가 정확히 닫혔는지 확인
            answer = true;
        }

        return answer;
    }
}

/*
import java.util.Stack;

class Solution {

    boolean solution(String s) {
        // 아직 닫히지 않은 '(' 들이 저장됨
        Stack<Character> stack = new Stack<>();

        // 문자열 s를 한 글자씩 순서대로 확인.
        // ex: s = "(())()" 이면
        // c는 '(' -> '(' -> ')' -> ')' -> '(' -> ')' 순서로 들어온다.
        for (char c : s.toCharArray()) {

            // 현재 문자가 '(' 인 경우
            // 열린 괄호 → 나중에 닫힐 것이므로 저장
            if (c == '(') {
                stack.push(c); // '(' 저장 (열린 괄호 개수 +1 효과)

            } else { // 현재 문자가 ')' 인 경우
                // 닫을 '('가 없다→ 즉시 실패. 있다면 → 가장 최근 '(' 하나와 짝 
                if (stack.isEmpty()) return false;
                
                stack.pop(); // 열린 괄호 개수 -1 효과
            }
        }

        // 남은 '(' 없음 → 성공. 남아 있음 → 실패
        return stack.isEmpty();
    }
}
*/