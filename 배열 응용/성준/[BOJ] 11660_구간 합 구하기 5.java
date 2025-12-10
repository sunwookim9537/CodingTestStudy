package StudyCodingTest.AplicationOfArrays;
/*
    1) 1차원 누적합 기본 개념
S[i] = S[i-1] + A[i]

2) 2차원 누적합 공식
S[x][y] = S[x-1][y] + S[x][y-1] − S[x-1][y-1] + A[x][y]




sum = S[x2][y2] − S[x1-1][y2] − S[x2][y1-1] + S[x1-1][y1-1]
  정렬된 배열에서 두 숫자의 합이 특정 목표값이 되는 두 숫자를 찾기
  input num = [1,2,4,7,11,15], target = 9;

    n(리스트 크기) m(질의 수)
    A(원본 리스트), D(합 배열)
    for (n 반복)
        원본 리스트 저장
    for (i=1 ~ n까지 반복)
        for j를 1부터 n까지 반복
        합 배열 저장
        공식 : D[x][y] = D[x-1][y] + D[x][y-1] − D[x-1][y-1] + D[x][y]
    (X1,Y1,X2,Y2)
    for (m만큼 반복)
        질의에 대한 결과 계산 및 출력
        D[X2][Y2] - D[X1-1][Y2] - D[X2][Y1 -1] + D[X1 -1][Y1 -1]
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_RangeSum5 {
    // BufferedReader 를 사용해서 시간초과 잡고
    // 입력 스트림 실패 가능하니까 예외처리 해.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 공백 기준 잘라
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N + 1][N + 1];
        int[][] D = new int[N + 1][N + 1];

        // 원본 배열 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2차원 누적합 생성
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                D[i][j] = D[i - 1][j] + D[i][j - 1] - D[i - 1][j - 1] + A[i][j];
            }
        }
        // 메모리 모았다가 한번에 보내
        StringBuilder sb = new StringBuilder();

        // 질의 처리
        while (M > 0) {
            M--;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = D[x2][y2]
                    - D[x1 - 1][y2]
                    - D[x2][y1 - 1]
                    + D[x1 - 1][y1 - 1];

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}
