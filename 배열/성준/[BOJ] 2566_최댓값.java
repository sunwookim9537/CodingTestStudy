package StudyCodingTest.Arr;
import java.util.Scanner;

/*
    int [9][9] 사이즈 정해져 있고
    for문으로 전부 다 값을 받고
    arr[][]>max 해서 구하고
    row, col 해서 +1 해줘서 1번부터 시작하게 만들기
*/
public class BOJ_MaximumValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사이즈 정하고
        int[][] arr = new int[9][9];

        int row = 0;
        int col = 0;
        // max 쓰려면 필요함
        // 몰라서 gpt 물어봄. max의 초기값은 항상 가장 작은 값이어야 한다!
        int max = Integer.MIN_VALUE;
/*
        // 최소값 구하려면
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = sc.nextInt();

                if (arr[i][j] < min) {
                    min = arr[i][j];
                    row = i + 1;
                    col = j + 1;
                }
            }
        }

 */
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                arr[i][j] = sc.nextInt();

                if(arr[i][j] > max){
                    max=arr[i][j];
                    row = i+1;
                    col = j+1;
                }
            }
        }
        //System.out.println(min);
        System.out.println(max);
        System.out.println(row +" "+ col);
    }
}
