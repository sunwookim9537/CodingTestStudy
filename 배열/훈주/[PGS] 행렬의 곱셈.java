class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 1. 행렬 크기 구하기
        int rowCount1 = arr1.length;       // arr1의 행 개수
        int colCount1 = arr1[0].length;    // arr1의 열 개수(= arr2의 행 개수)
        int colCount2 = arr2[0].length;    // arr2의 열 개수

        // 2. 결과를 저장할 배열 생성
        int[][] answer = new int[rowCount1][colCount2];

        // 3. 행렬 곱셈 수행
        for (int i = 0; i < rowCount1; i++) {          // arr1의 각 행
            for (int j = 0; j < colCount2; j++) {      // arr2의 각 열
                int sum = 0;                           // answer[i][j]를 만들 누적합

                // arr1의 열 개수(=arr2의 행 개수)만큼 곱하고 더하기
                for (int k = 0; k < colCount1; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }

                // 계산된 값을 결과 배열의 해당 위치에 저장
                answer[i][j] = sum;
            }
        }

        // 4. 완성된 결과 행렬 반환
        return answer;
    }
}