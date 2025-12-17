package studycodingtest.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/*
    명령 개수 N
    Scanner 사용하고
    while()
        나머지 전부다 case 사용해서 만들면 될거 같은데
    // 밑에꺼 쓰고 계속 시간초과 뜸...
    Scanner sc = new Scanner(System.in);
    Queue<Integer> queue = new LinkedList<>();
 */
public class BOJ_Queue2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    queue.addLast(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    // pollFirst 앞에 요소 제거 + 반환
                    sb.append(queue.isEmpty() ? -1 : queue.pollFirst()).append('\n');
                    break;

                case "size":
                    sb.append(queue.size()).append('\n');
                    break;

                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;

                case "front":
                    // peekFirst 앞 요소 조회
                    sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append('\n');
                    break;

                case "back":
                    sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append('\n');
                    break;
            }
        }

        System.out.print(sb.toString());
    }
}

