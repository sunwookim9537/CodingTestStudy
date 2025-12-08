class Solution {
    public int solution(String[][] board, int h, int w) {
        
        int n = board.length;        // (1)n = board 길이
        int count = 0;               // (2)count 생성

        int[] dh = {0, 1, -1, 0};    // (3)dh, dw 생성
        int[] dw = {1, 0, 0, -1};    // (3)dh, dw 생성

        String curColor = board[h][w];

        for (int i = 0; i < 4; i++) {             // (4)i=0~3 반복
            int h_check = h + dh[i];              // (4-1)h+dh[i], w+dw[i]
            int w_check = w + dw[i];              // (4-1)h+dh[i], w+dw[i]

            if (h_check >= 0 && h_check < n &&    // (4-2)범위 확인
                w_check >= 0 && w_check < n) {

                if (curColor.equals(board[h_check][w_check])) { // (4-2-a)색 비교
                    count++;
                }
            }
        }

        return count;   // (5)count 리턴
    }
}


/*
class Solution {
    public int solution(String[][] board, int h, int w) {

        int n = board.length;        // (1) n = board 길이
        int count = 0;               // (2) count 생성

        String curColor = board[h][w];

        // 위쪽 (i = 2에 해당) → h + dh[2] = h - 1
        int h_check = h - 1;         // (4-1) 체크할 좌표 직접 계산
        int w_check = w;
        if (h_check >= 0 && h_check < n) {        // (4-2) 범위 체크
            if (curColor.equals(board[h_check][w_check])) {  // (4-2-a) 색 비교
                count++;
            }
        }

        // 아래쪽 (i = 1) → h + dh[1] = h + 1
        h_check = h + 1;             // (4-1)
        w_check = w;
        if (h_check >= 0 && h_check < n) {        // (4-2)
            if (curColor.equals(board[h_check][w_check])) {  // (4-2-a)
                count++;
            }
        }

        // 왼쪽 (i = 3) → w + dw[3] = w - 1
        h_check = h;
        w_check = w - 1;
        if (w_check >= 0 && w_check < n) {        // (4-2)
            if (curColor.equals(board[h_check][w_check])) {  // (4-2-a)
                count++;
            }
        }

        // 오른쪽 (i = 0) → w + dw[0] = w + 1
        h_check = h;
        w_check = w + 1;
        if (w_check >= 0 && w_check < n) {        // (4-2)
            if (curColor.equals(board[h_check][w_check])) {  // (4-2-a)
                count++;
            }
        }

        return count;   // (5)
    }
}
*/