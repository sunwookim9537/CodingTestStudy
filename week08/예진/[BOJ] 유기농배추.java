import java.util.*;
import java.io.*;

class Main {

    private static final int[] dx = { -1, 0, 1, 0 };
    private static final int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        /*
         * 1인 부분 찾으면 dfs로 탐색하여 영역 방문처리
         * count로 영역 개수 세기
         */

        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테스트케이스 반복
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            
            // 가로 길이 M, 세로 길이 N, 배추 위치 개수 K
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 2차원 배열로 배추밭 저장
            int[][] field = initField(br, M, N, K);

            // 필요한 지렁이 개수
            int wormRequired = countWorm(field);

            // 출력
            System.out.println(wormRequired);
        }

    }

    private static int countWorm(int[][] field) {
        int result = 0;
        boolean[][] visited = new boolean[field.length][field[0].length];

        // 밭을 순회하면서 1인 곳을 찾으면 영역 + 1
        // 연결된 영역을 모두 방문처리
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == 1 && visited[i][j] == false) {
                    dfs(field, visited, i, j); // 연결된 밭 영역 방문
                    result++;
                }
            }
        }

        return result;
    }

    // 배추 영역을 모두 탐색하여 visited를 업데이트
    private static void dfs(int[][] field, boolean[][] visited, int x, int y) {
        
        // 영역이 유효한지 검사
        if (x < 0 || y < 0 || x >= field.length || y >= field[0].length) {
            return;
        }
        
        // 이미 방문했거나, 배추가 심어진 곳 아닌 경우 리턴
        if (visited[x][y] || field[x][y] == 0) {
            return;
        }
        
        // 배추 심어진 자리이면서 방문 안한 자리이면 방문처리
        if (field[x][y] == 1 && visited[x][y] == false) {
            visited[x][y] = true;
        }

        // 주변 영역(상, 하, 좌, 우) 탐색
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            dfs(field, visited, nx, ny);
        }
    }

    private static int[][] initField(BufferedReader br, int width, int height, int planted) throws IOException {
        int[][] field = new int[width][height];

        // 배추 위치 입력
        for (int i = 0; i < planted; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            field[X][Y] = 1;
        }

        return field;
    }
}