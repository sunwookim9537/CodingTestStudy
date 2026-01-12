import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
조건: 그래프는 ‘양방향’, 정점 번호가 작은 것부터 방문, DFS / BFS는 ‘방문 순서’를 출력

1. 그래프를 **인접 리스트**로 만든다.
2. **정렬**한다(작은 번호 우선 조건)
3. DFS 한 번
4. visited 초기화
5. BFS 한 번
*/

public class Main {
    static List<Integer>[] graph; //i번 정점과 연결된 정점들의 목록
    static boolean[] visited; // i번 정점을 방문했는지 여부
    static StringBuilder sb = new StringBuilder(); // 한번에 출력

    // ===== DFS (깊이 우선 탐색) =====
    static void dfs(int v) {
        visited[v] = true; // 현재 정점 v를 방문 처리
        sb.append(v).append(" "); // 방문 순서 기록

        // v와 연결된 모든 정점들을 순서대로 확인
        for (int next : graph[v]) {
            if (!visited[next]) { // 아직 방문하지 않은 정점이면
                dfs(next); // 그 정점으로 다시 DFS (깊게 들어감)
            }
        }
    }

    // ===== BFS (너비 우선 탐색) =====
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>(); // BFS는 Queue(큐)를 사용

        visited[start] = true; // 시작 정점 방문 처리
        queue.offer(start);  // 시작 정점을 큐에 넣음

        while (!queue.isEmpty()) { // 큐가 빌 때까지 반복
            int v = queue.poll(); // 큐의 맨 앞 정점을 하나 꺼냄
            sb.append(v).append(" "); // 방문 순서 기록

            // v와 연결된 모든 정점 확인
            for (int next : graph[v]) {
                if (!visited[next]) { // 아직 방문하지 않은 정점이면
                    visited[next] = true; // 방문 처리 후
                    queue.offer(next); // 큐에 추가 (같은 깊이 순서대로 처리됨)
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: N(정점 수), M(간선 수), V(시작 정점)
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int V = Integer.parseInt(st.nextToken()); // 시작 정점

        // 그래프 초기화 (1번 정점부터 사용)
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력 (양방향 그래프)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a ↔ b 연결
            graph[a].add(b);
            graph[b].add(a);
        }

        // 문제 조건: 번호가 작은 정점부터 방문해야 하므로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 실행
        visited = new boolean[N + 1];
        dfs(V);
        sb.append('\n');

        // BFS 실행 (visited 배열 초기화 필수)
        visited = new boolean[N + 1];
        bfs(V);

        // 결과 출력
        System.out.print(sb.toString());
    }
}