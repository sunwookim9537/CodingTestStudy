package StudyCodingTest.Arr;

public class PGS_MatrixMultiplication {

    public static void main(String[] args) {
        Solution sol = new Solution();


        // ===== 예제 1 =====
        int[][] arr1_1 = {
                {1, 4},
                {3, 2},
                {4, 1}
        };
        int[][] arr2_1 = {
                {3, 3},
                {3, 3}
        };

        int[][] result1 = sol.solution(arr1_1, arr2_1);
        System.out.println("=== 예제 1 결과 ===");
        print(result1);

        // ===== 예제 2 =====
        int[][] arr1_2 = {
                {2, 3, 2},
                {4, 2, 4},
                {3, 1, 4}
        };
        int[][] arr2_2 = {
                {5, 4, 3},
                {2, 4, 1},
                {3, 1, 1}
        };

        int[][] result2 = sol.solution(arr1_2, arr2_2);
        System.out.println("\n=== 예제 2 결과 ===");
        print(result2);
    }

    // 출력 함수
    static void print(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    /*
        풀면서 행렬은 원래 (n*m) x (m*k) = n*k 이런식임
        int [0][0] = (arr1[0][0] * arr2[0][0]) + (arr1[0][1] + arr2[1][0]) 계산한다는거잖아.
        그럼 이중 for 문 먼저 써주고 arr1 행 * arr2 열 을 해준다는건데 근데 행과 열의 길이가 2~100이면 3중 for문 써서 횟수 정하라고?
        3중 for문 시간 복잡도는 O(N^3) 인데?? 그러면 100^3 = 1000000 인데? 그럼 1억 안넘어서 괜찮은겨? 이건 물어보자

    */
    public static class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int arr1Row = arr1.length; // arr1 행
            int arr1Col = arr1[0].length; // arr1 열 근데 이게 arr2 행
            int arr2Col = arr2[0].length; // arr2 열

            int[][] answerArr = new int[arr1Row][arr2Col];
            for(int i = 0; i < arr1Row; i++){
                for(int j = 0; j < arr2Col; j++){
                    for(int k = 0; k<arr1Col; k++){
                        answerArr[i][j] += arr1[i][k] * arr2[k][j];
                    }
                }
            }

            return answerArr;
        }
    }
}
