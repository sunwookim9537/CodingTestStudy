import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // 카드2는 입력이 "한 줄, 정수 1개" 뿐이다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        Queue<Integer> queue = new LinkedList<>();

        // 1 ~ N 카드 넣기
        for (int i = 1; i <= N; i++) {
            queue.offer(i); // offer: 뒤에 삽입 (큐의 back에 추가)
        }

        // 카드가 1장 남을 때까지 규칙을 반복
        while (queue.size() > 1) {
		        queue.poll(); // 1) 맨 위 카드 버리기. 큐의 front 꺼내고 삭제(poll)

            // 2) 다음 맨 위 카드, 맨 아래로 옮기기.
            // => front에서 하나 꺼낸 뒤, 다시 back에 넣기
            queue.offer(queue.poll());
        }

        // 마지막 남은 카드(큐의 front == back)를 출력
        System.out.println(queue.peek());
    }
}