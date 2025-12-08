 

import java.util.Arrays;
import java.util.Scanner;
 
/* 백준 좋다 골드4 */
public class Main {

    // 정렬
    /*
    * 좋은 수 유무를 알기 위해서는 두 수의 합이 되는지 알아야함
    * 합이 되는 두 수를 구하기 위해 투포인터 사용 -> 이 때 범위는 0~n-1 -> target보다 큰 수를 더할 수는 없으므로.
    * 
    * 배열을 오름차순 정렬
    * for문으로 배열 순회
    * 탐색 범위는 start = 0, end = arr[i-1]
    * 시간 복잡도 -> NlogN
    */
    public static void main(String[] args) {
        int count = 0;

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        // 오름차순 정렬 필수
        Arrays.sort(arr);

        // 배열 순회하면서 좋은 수인지 판단
        for(int i = 0; i < N; i++){
            int target = arr[i];
            int start = 0;
            int end = N - 1;

            // 합이 되는 두 수 탐색
            while(start < end){
                int sum = arr[start] + arr[end];
                if(target == sum) {
                    if(i != start && i != end) {
                        count++;
                        break;
                    }
                    else if(i == start){
                        start++;
                    }
                    else if(i == end){
                        end--;
                    }
                }
                else if(target < sum) end--;
                else start++;
            }
        }

        System.out.println(count);
        sc.close();

        return;
    }

}
