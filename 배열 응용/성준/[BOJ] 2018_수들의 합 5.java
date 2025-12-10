package StudyCodingTest.AplicationOfArrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
    포인터 유튜브
    https://youtu.be/loHvjz4PXFc?si=uUcda7kEqJQ2u0Wn
    참고
*/
public class BOJ_SumNumbers5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int left = 1, right = 1;
        int sum = 1;
        int count = 0;

        while (left <= N) {

            if (sum == N) {      // 정답 하나 발견
                count++;
                sum -= left;
                left++;
            }
            else if (sum < N) {  // sum을 키우기 위해 구간 확장
                right++;
                sum += right;
            }
            else {               // sum > N → 구간 줄이기
                sum -= left;
                left++;
            }
        }

        System.out.println(count);
    }
}

/*
package StudyCodingTest.TwoPointers;
//
//  정렬된 배열에서 두 숫자의 합이 특정 목표값이 되는 두 숫자를 찾기
//  input num = [1,2,4,7,11,15], target = 9;
//
//  1. p1, p2 set
//  2. nums[p1] + nums[p2] > target

public class SumTwoArrays {

    public static int[] sumTwoArrays(int[] nums,int target){
        int left = 0; // 왼쪽 포인터
        int right = nums.length - 1; // 오른쪽 포인터

        while (left < right){
            int sum = nums[left] + nums[right];  // 두 포인터의 합 저장

            // 첫번째 탈출 방법
            if (sum == target){
                return new int[] {left, right};
            }else if(sum < target){
                left++;
            } else {
                right--;
            }
        }
        // 아무것도 못찾으면 출력 x
        return new int[] {0};
    }
    public static void main(String[] args) {
        int [] nums = {1,2,4, 7, 11 ,15};
        int target = 9;

        int [] result = sumTwoArrays (nums, target);

        if(result.length == 2){
            System.out.println("두 숫자의 인덱스: ["+result[0] +"," + result[1] +"]");
        }else{
            System.out.println("조건에 맞는 두 숫자가 없다.");
        }
    }

}

 */