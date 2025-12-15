import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // [입력 최적화] N이 최대 2,000,000이므로 Scanner는 위험.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // [출력 최적화] 출력이 많으므로 StringBuilder에 모아 한 번에 출력.
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // [자료구조 선택]
        // ArrayDeque는 LinkedList보다 빠른 경우가 많고(배열 기반),
        // 앞/뒤 삽입/삭제가 모두 O(1)로 가능하다.
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            // split(" ")는 내부적으로 정규식을 써서 2,000,000줄에서 부담이 될 수 있다.
            // 하지만 "push X"만 추가 토큰이 있고 나머지는 단어 1개라
            // 최소한의 파싱으로 처리하는 편이 더 안전하다.
            if (line.charAt(0) == 'p') { // push / pop 둘 다 p로 시작
                if (line.charAt(1) == 'u') { // "push"
                    int x = Integer.parseInt(line.substring(5)); // "push " 다음부터 숫자
                    dq.offerLast(x); // 뒤에 삽입
                } else { // "pop"
                    if (dq.isEmpty()) sb.append(-1);
                    else sb.append(dq.pollFirst()); // 앞에서 삭제+반환
                    sb.append('\n');
                }
                continue;
            }

            // 나머지 명령은 문자열 그대로 비교해도 됨
            switch (line) {
                case "size":
                    sb.append(dq.size()).append('\n');
                    break;

                case "empty":
                    sb.append(dq.isEmpty() ? 1 : 0).append('\n');
                    break;

                case "front":
                    sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append('\n');
                    break;

                case "back":
                    sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append('\n');
                    break;
            }
        }

        System.out.print(sb);
    }
}