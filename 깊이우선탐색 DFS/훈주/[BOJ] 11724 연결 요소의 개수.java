import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
“한 정점에서 시작했을 때,
그 정점과 연결된 모든 정점을 한 번에 다 찾을 수 없을까?”
→ 미방문 정점에서 DFS/BFS 시작 시 그 자체로 하나의 연결 요소
➡ DFS 한 번 = 연결 요소 1개

1. 그래프를 만든다 (인접 리스트)
2. visited 배열을 만든다
3. 1번 정점부터 N번 정점까지 확인
4. 아직 방문하지 않은 정점 발견
   → DFS 시작
   → 연결된 모든 정점 방문 처리
   → 연결 요소 개수 +1 
“DFS 한 번으로 한 덩어리를 전부 방문 가능”
*/

public class Main {
    static ArrayList<Integer>[] graph; //i번 정점과 직접 연결된 정점들의 목록
    static boolean[] visited; // i번 정점을 이미 한 번이라도 방문했는지 여부

    // dfs(v)
    // v번 정점에서 시작해서,
    // v와 "연결되어 있는 모든 정점"을 전부 방문 처리하는 함수
    static void dfs(int v) {
        visited[v] = true;   // v번 정점을 방문했다고 표시
        for (int next : graph[v]) { // v번 정점과 연결된 모든 정점을 하나씩 확인
            if (!visited[next]) { // 미방문 정점일 시,
                dfs(next);   // 그 정점으로 이동해서 계속 탐색
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점(점)의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선(선)의 개수

        // 그래프와 방문 배열 준비
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        // 각 정점마다 연결 목록(ArrayList)을 하나씩 만들어 줌
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        // 무방향 그래프이므로 양쪽에 모두 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 한쪽 정점
            int v = Integer.parseInt(st.nextToken()); // 다른 쪽 정점

            graph[u].add(v);
            graph[v].add(u);
        }

        int count = 0; // 연결 요소(덩어리)의 개수
        for (int i = 1; i <= N; i++) { // 1번 정점부터 N번 정점까지 전부 확인
            if (!visited[i]) { // 미방문 정점 발견 시,
                dfs(i); // 그 정점이 속한 "덩어리 전체"를 DFS로 방문
                count++; // DFS 한 번 = 연결된 덩어리 1개
            }
        }
        System.out.println(count); // 최종 연결 요소 개수 출력
    }
}