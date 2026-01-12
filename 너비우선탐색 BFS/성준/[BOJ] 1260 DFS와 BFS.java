package studycodingtest.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
    조건
    1. 정점 번호 1~N
    2. 같은 간선이 여러 번 나올 수 있어
    3. 정점 중 선택 가능하면 작은 번호부터 방문
 */
public class BOJ_dfsAndbfs {
    static int N, M, V;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visitedDFS;
    static boolean[] visitedBFS;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visitedDFS = new boolean[N + 1];
        visitedBFS = new boolean[N + 1];

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력 (무방향)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 정점 번호 작은 것부터 방문하기 위해 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // DFS
        dfs(V);
        sb.append("\n");

        // BFS
        bfs(V);

        System.out.print(sb.toString());
    }
    
    // DFS 재귀 사용
    static void dfs(int v) {
        visitedDFS[v] = true;
        sb.append(v).append(" ");

        for (int next : graph.get(v)) {
            if (!visitedDFS[next]) {
                dfs(next);
            }
        }
    }
    
    //BFS 큐 구현
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visitedBFS[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append(" ");

            for (int next : graph.get(current)) {
                if (!visitedBFS[next]) {
                    visitedBFS[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
