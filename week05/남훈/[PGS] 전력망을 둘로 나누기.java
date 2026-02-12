class Solution {
    private int[][] graph;
    private boolean[] visited;

    public int solution(int n, int[][] wires) {
        // 두 전력망의 송전탑 개수 차이의 최솟값
        int minDifference = n;
        graph = new int[n+1][n+1];

        // 그래프 구성 -> 양방향으로 구성
        for (int[] wire : wires) {
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }

        // 각 전선을 끊어보며 최소 차이 계산
        for (int[] wire : wires) {
            // 전선 끊기
            graph[wire[0]][wire[1]] = 0;
            graph[wire[1]][wire[0]] = 0;

            int count = countNodes(wire[0], n);
            minDifference = Math.min(minDifference, Math.abs(n - 2 * count));

            // 전선 복구
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }

        return minDifference;
    }

    private int countNodes(int start, int n) {
        visited = new boolean[n + 1];
        return dfs(start);
    }

    private int dfs(int node) {
        visited[node] = true;
        int count = 1;

        for (int neighbor = 1; neighbor < graph.length; neighbor++) {
            // 연결되어 있고 (graph[node][neighbor] == 1) 아직 방문하지 않은 (!visited[neighbor]) 이웃 노드에 대해
            if (graph[node][neighbor] == 1 && !visited[neighbor]) {
                // dfs 수행 후 count 누적 (연결된 노드 수)
                count += dfs(neighbor);
            }
        }

        return count;
    }
}