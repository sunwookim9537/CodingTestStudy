import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // 입력이 최대 100,000줄이라 Scanner보다 BufferedReader가 빠르고 안정적
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열 길이 n
        int n = Integer.parseInt(br.readLine());

        // "현재까지 push해둔 값들"을 담는 스택
        // 스택의 top이 "지금 당장 pop 가능한 값"이다.
        Stack<Integer> stack = new Stack<>();

        // 연산(+, -)을 모아서 출력하기 위한 StringBuilder
        // 한 줄씩 System.out.println을 100,000번 하면 느려질 수 있음
        StringBuilder sb = new StringBuilder();

        // 1부터 n까지 오름차순으로만 push해야 하므로,
        // "다음에 push할 숫자"를 current로 관리한다.
        int current = 1;

        // target 수열을 앞에서부터 하나씩 만들어 간다.
        for (int i = 0; i < n; i++) {

            // 이번에 반드시 pop해서 만들어야 하는 값
            int target = Integer.parseInt(br.readLine());

            // (1) target을 pop하려면, 먼저 target이 스택 top에 있어야 한다.
            // 그런데 push는 current부터 오름차순만 가능.
            // 그래서 current <= target인 동안은 계속 push해서 target을 스택에 올려야 한다.
            while (current <= target) {
                stack.push(current);   // current 값을 스택에 넣고
                current++;             // 다음 push 후보 숫자를 1 증가
                sb.append("+\n");      // push 연산 기록
            }

            // (2) 이제 target은 "이미 push되어 있다"는 상태.
            // 이 시점에서 가능한 경우는 딱 하나:
            // stack의 top이 target이면 pop해서 수열을 만든다.
            //
            // 만약 top이 target이 아니라면?
            // 예: top이 더 큰 수면 target은 스택 아래에 묻혀있다는 뜻.
            // 스택은 top만 pop 가능하므로 target을 꺼낼 방법이 없다 -> 불가능(NO).
            if (stack.isEmpty() || stack.peek() != target) {
                System.out.println("NO");
                return; // 즉시 종료 (뒤는 볼 필요 없음)
            }

            // (3) top이 target이면 pop해서 수열의 다음 원소를 만든다.
            stack.pop();
            sb.append("-\n"); // pop 연산 기록
        }

        // 끝까지 문제 없이 처리되면 누적된 연산 출력
        System.out.print(sb.toString());
    }
}