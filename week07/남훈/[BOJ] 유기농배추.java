import java.util.*;

import java.util.Scanner;
public class Main {

    static int[][] map;          // 배추밭
    static boolean[][] visited;  // 방문 체크
    static int N, M;             // 배추밭 크기 (행, 열)
    static int[] dx = {1, -1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, 1, -1};

    static void dfs(int x, int y){
        visited[x][y] = true;

        for (int i=0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            M = sc.nextInt(); // 가로
            N = sc.nextInt(); // 세로
            int K = sc.nextInt(); // 배추 개수

            map = new int[N][M];
            visited = new boolean[N][M];

            int count = 0;

            for (int i=0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = 1;
            }

            for (int i=0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if (map[i][j] == 1 && !visited[i][j]){
                        dfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

        sc.close();
    }
}