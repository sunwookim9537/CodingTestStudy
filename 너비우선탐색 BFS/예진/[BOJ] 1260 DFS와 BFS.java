import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/* 백준 DFS와 BFS */
public class Main {
    /**
     * BFS
     * 구현: Queue
     * 동작 원리: 큐가 빌 때 까지 다음을 반복
     * - 1. 큐에서 노드 pop
     * - 2. 꺼낸 노드와 연결괸 방문하지 않은 모든 인접 노드 방문 처리
     * 시간복잡도
     * 공간복잡도
     * 
     * @param args
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점 개수
        int N = Integer.parseInt(st.nextToken());

        // 간선 개수
        int M = Integer.parseInt(st.nextToken());

        // 시작하는 정점
        int V = Integer.parseInt(st.nextToken());

        // 그래프
        List<Integer>[] graph = new ArrayList[N + 1];

        // 그래프 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 입력받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[e].add(v);
            graph[v].add(e);
        }

        // 그래프 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // System.out.println(Arrays.toString(graph));

        // DFS
        dfs(new boolean[N + 1], graph, V);
        System.out.println();

        // BFS
        bfs(new boolean[N + 1], graph, V);

    }

    private static void dfs(boolean[] visited, List<Integer>[] graph, int node) {
        if (visited[node])
            return;

        // 방문한 노드 처리
        visited[node] = true;
        System.out.print(node + " ");

        // 다음 노드 탐색
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(visited, graph, next);
            }
        }

    }

    private static void bfs(boolean[] visited, List<Integer>[] graph, int node) {
        Queue<Integer> q = new LinkedList<>();

        // 방문한 노드 처리
        visited[node] = true;

        // 방문한 노드 큐에 삽입
        q.offer(node);

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            // 1. 큐에서 값을 꺼낸다
            int cur = q.poll();
            System.out.print(cur + " ");

            // 2. 해당 값과 연결된 값들을 모두 방문한다
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

    }
}
