package bfs;

import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int[][] dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();


        q.offer(new int[]{0, 0});
        dist[0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];


                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;


                if (maps[nx][ny] == 0) continue;


                if (dist[nx][ny] != 0) continue;


                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }


        return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
    }
}
