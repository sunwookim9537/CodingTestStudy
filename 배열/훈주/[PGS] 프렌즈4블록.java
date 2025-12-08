class Solution {

    public int solution(int m, int n, String[] board) {

        // 1. String[] -> char[][] 로 변환
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {              // 행
            for (int j = 0; j < n; j++) {          // 열
                map[i][j] = board[i].charAt(j);
            }
        }

        int totalRemoved = 0; // 지워진 칸 총 개수

        while (true) {
            // 2. 이번 턴에 지울 칸 표시할 배열
            boolean[][] toRemove = new boolean[m][n];

            // 3. 2x2 같은 문자 찾기
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = map[i][j];

                    // 빈칸('0')이 아니면서 2x2 네 칸이 모두 같은 문자일 때
                    if (c != '0' &&
                        c == map[i][j + 1] &&
                        c == map[i + 1][j] &&
                        c == map[i + 1][j + 1]) {

                        toRemove[i][j] = true;
                        toRemove[i][j + 1] = true;
                        toRemove[i + 1][j] = true;
                        toRemove[i + 1][j + 1] = true;
                    }
                }
            }

            // 4. 표시된 칸 실제로 지우기 + 개수 세기
            int removedThisTurn = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (toRemove[i][j] && map[i][j] != '0') {
                        map[i][j] = '0'; // 빈칸으로
                        removedThisTurn++;
                    }
                }
            }

            // 5. 이번 턴에 아무것도 안 지워졌으면 끝
            if (removedThisTurn == 0) {
                break;
            }

            totalRemoved += removedThisTurn;

            // 6. 블록 아래로 떨어뜨리기 (열 단위로 처리)
            for (int col = 0; col < n; col++) {
                int writeRow = m - 1;   // 아래에서부터 채우기 시작할 위치

                // 아래에서 위로 올라가면서 살아있는 블록들만 모아서 아래로 내리기
                for (int row = m - 1; row >= 0; row--) {
                    if (map[row][col] != '0') {
                        map[writeRow][col] = map[row][col];
                        writeRow--;
                    }
                }

                // 남은 윗부분은 전부 빈칸으로 채우기
                for (int row = writeRow; row >= 0; row--) {
                    map[row][col] = '0';
                }
            }
        }

        return totalRemoved;
    }
}