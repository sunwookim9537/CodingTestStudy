import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드 개수

        // 1. 인접 리스트 생성
        ArrayList<Integer>[] tree = new ArrayList[n + 1]; // 1번부터 사용
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // 2. 입력으로 연결 정보 저장 (양방향)
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree[a].add(b);
            tree[b].add(a);
        }

        // 3. 부모 배열과 방문 체크 배열
        int[] parent = new int[n + 1]; // parent[i] = i의 부모
        boolean[] visited = new boolean[n + 1];

        // 4. BFS 탐색
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // 루트 1번부터 시작
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll(); // 현재 노드

            for (int next : tree[current]) { // 인접 노드 확인
                if (!visited[next]) { // 처음 방문한 노드면
                    visited[next] = true; // 방문 처리
                    parent[next] = current; // 부모 기록
                    queue.add(next); // 큐에 추가
                }
            }
        }

        // 5. 결과 출력 (2번 노드부터)
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
}