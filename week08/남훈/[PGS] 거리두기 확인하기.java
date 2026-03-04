import java.util.*;

class Solution {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        // 각 대기실의 결과를 저장할 배열
        int[] answer = new int[places.length];
        // 대기실 하나씩 검사
        for (int t = 0; t < places.length; t++) {
            // 문자열 배열을 문자 배열로 변환
            char[][] map = new char[5][5];

            for (int i = 0; i < 5; i++) {
                map[i] = places[t][i].toCharArray();
            }
            boolean check = true;
            // 모든 좌표를 탐색
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    // 사람이 있으면 BFS 시작
                    if (map[i][j] == 'P') {
                        // BFS 결과가 false이면 거리두기 위반
                        if (!bfs(i, j, map)) {
                            check = false;
                        }
                    }
                }
            }
            // 거리두기 지키면 1, 아니면 0
            answer[t] = check ? 1 : 0;
        }
        return answer;
    }

    public boolean bfs(int x, int y, char[][] map) {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 큐의 맨 앞 원소 꺼냄
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            if (dist >= 2) continue;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    // 만약 거리 1~2 안에 다른 사람이 있으면 위반
                    if (map[nx][ny] == 'P') {
                        return false;  // 거리두기 위반
                    }
                    // 빈 자리(O)라면 계속 탐색
                    if (map[nx][ny] == 'O') {
                        queue.add(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }
        return true;
    }
}