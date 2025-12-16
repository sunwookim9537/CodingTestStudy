import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;

        // answer[i] = i 시점 가격이 "떨어지지 않은 기간(초)"
        int[] answer = new int[n];

        // 스택에 "아직 가격이 떨어진 시점을 못 찾은 인덱스"를 저장.
        // 즉, 스택에 남아있다는 것은:
        // "이 인덱스의 가격은 아직까지 하락한 적이 없다(답 미확정)" 상태.
        Stack<Integer> stack = new Stack<>();

        // i는 현재 시간(인덱스)
        for (int i = 0; i < n; i++) {

            // [핵심 while]
            // [현재 가격(prices[i]) < 스택 top 인덱스의 가격](=하락)
            // 스택 top 인덱스는 "지금 i에서 처음으로 가격이 떨어진 것"이 확정된다.
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {

                // 하락이 확정된 과거 시점 idx를 꺼낸다.
                int idx = stack.pop();

                // idx 시점 가격은 i 시점에서 처음으로 떨어졌다.
                // 따라서 "떨어지지 않은 기간"은 (i - idx)초
                answer[idx] = i - idx;
            }

            // 현재 인덱스 i는 아직 미래를 모르므로 스택에 넣어 "미해결"로 보관
            stack.push(i);
        }

        // for문이 끝났는데도 남은 스택: 끝까지 가격이 "한 번도 떨어지지 않은" 인덱스들.
        // 인덱스 idx의 유지 시간은 "끝까지 남은 시간" = (n - 1 - idx)
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = n - 1 - idx;
        }

        return answer;
    }
}