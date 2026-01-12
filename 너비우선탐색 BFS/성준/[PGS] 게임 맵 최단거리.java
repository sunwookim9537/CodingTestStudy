package studycodingtest.bfs;

import java.util.*;

/*
    BFS사용
     visited, Queue(FIFO) 사용
      boolean [][] visited = new boolean[w][h];
      Queue<int[]> q = new LinkedList<>();
       q.offer(new int[]{0,0,1}); // 시작 좌표 이동할 거리 1
       visited[0][0] = true;

    방향 배열
     int[] dx = {1, -1, 0, 0};
     int[] dy = {0, 0, 1, -1};

 */
public class PGS_ShortestPathInAGameMap {
    class Solution {
        // 방향 배열 안바뀌니까 final 로 잡아두고
        private static final int[] dx = {1, -1, 0, 0};
        private static final int[] dy = {0, 0, 1, -1};

        public int solution(int[][] maps) {
            int n = maps.length; // 행
            int m = maps[0].length; // 열

            // BFS visited , Queue
            boolean[][] visited = new boolean[n][m];
            Queue <int[]> q = new LinkedList<>();

            // 초기화
            q.offer (new int[]{0,0,1});
            visited [0][0] = true;

            // 반복문 진행
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0]; // x 좌표
                int y = cur[1]; // y 좌표
                int dist = cur[2]; // 이동한 거리

                // 목적지 확인
                if(x == n -1 && y == m - 1) {
                    return dist;
                }

                // 방향 탕색
                for(int i = 0; i< 4; i++){
                    int nx = x + dx[i];
                    int my = y + dy[i];

                    if(nx < 0 || my < 0 || nx >= n || my >= m) continue;
                    if(maps[nx][my] == 0 || visited[nx][my]) continue;

                    visited[nx][my] = true;
                    q.offer(new int[]{nx,my, dist+1});
                }
            }
            // 목적지 도달 못하면
            return -1;
        }
    }
}