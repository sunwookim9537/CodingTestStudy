import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 9x9 배열 선언
        try (Scanner scanner = new Scanner(System.in)) {
            // 9x9 배열 선언
            int[][] arr = new int[9][9];
            
            int max = -1;   // 최댓값 (입력값은 0~100이므로 -1로 시작 가능)
            int row = 0;    // 최댓값이 있는 행 번호
            int col = 0;    // 최댓값이 있는 열 번호
            
            // 2차원 배열 입력 + 최댓값 찾기
            for (int i = 0; i < 9; i++) {           // 행(0~8)
                for (int j = 0; j < 9; j++) {       // 열(0~8)
                    arr[i][j] = scanner.nextInt();
                    
                    // 현재 값이 지금까지의 최댓값보다 크면 갱신
                    if (arr[i][j] > max) {
                        max = arr[i][j];
                        row = i + 1;   // 문제는 1행부터 시작하므로
                        col = j + 1;
                    }
                }
            }
            
            // 출력
            System.out.println(max);
            System.out.println(row + " " + col);
        }
    }
}