import java.util.LinkedList;
import java.util.Queue;

/*
“이 문제에서 한 칸 이동의 비용은 모두 같은가?”

1. 목표: 최단거리인가?
2. 이동 비용이 전부 같은가?
    → YES
3. BFS
4. 시작점 큐에 넣기
5. 상/하/좌/우로 확장
6. 처음 도착한 거리 return
7. 못 가면 -1

최단거리 문제인데 모든 이동 비용이 같다 → BFS ”거리순서대로”
먼저 도착한 경로는 무조건 차단이므로 나중 도착 경로는 볼 필요가 없어지기 때문에, “어디로 갈까?”가 아닌 “언제 도착했나?”

`(0,0)` → 시작 노드
`(n-1,m-1)` → 도착 노드
*/

class Solution {

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[][] dist = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        // 시작점
        queue.offer(new int[]{0, 0});
        dist[0][0] = 1;

        // 상, 하, 좌, 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            // 도착 지점에 처음 도달하면 바로 반환 가능 (선택)
            if (x == n - 1 && y == m - 1) {
                return dist[x][y];
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 맵 범위 밖
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // 벽이거나 이미 방문한 칸
                if (maps[nx][ny] == 0 || dist[nx][ny] != 0) continue;

                dist[nx][ny] = dist[x][y] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }

        // 도착 불가능
        return -1;
    }
}