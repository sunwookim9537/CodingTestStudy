// 문자열 배열 maps -> 가로: x, 세로: y
// 유니공 배추랑 비슷하니 dfs로 풀면 될듯
// 무인도 땅이 있는 칸마다 일수(d)를 구해야 함

// 근데 섬 위치가 배열로 그대로 들어가야함
// 연결된 땅의 일수를 모두 더해야 되니까 d += map[x][y];..?
// dfs 에서는 x인 부분도 피해야함

import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;
    static boolean[][] visited;
    static char[][] map;
    static int sum;

    static void dfs(int x, int y) {
        visited[x][y] = true;
        sum += map[x][y] - '0'; // 문자 숫자 -> 정수

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (!visited[nx][ny] && map[nx][ny] != 'X') {
                    dfs(nx, ny);
                }
            }
        }
    }

    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        map = new char[N][M];

        // 문자열 배열 -> char 배열
        for (int i = 0; i < N; i++) {
            map[i] = maps[i].toCharArray(); // "X591X" → {'X','5','9','1','X'}
        }

        ArrayList<Integer> result = new ArrayList<>(); // sum 담는 리스트

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] != 'X') {
                    sum = 0;         // 새로운 섬 시작
                    dfs(i, j);
                    result.add(sum); // 섬의 일수 합
                }
            }
        }

        if (result.isEmpty()) return new int[]{-1};

        // 오름차순 정렬 후 배열로 변환
        Collections.sort(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}