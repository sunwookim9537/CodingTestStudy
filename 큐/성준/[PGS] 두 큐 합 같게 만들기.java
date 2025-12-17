package studycodingtest.queue;

import java.util.Scanner;
/*
    FIFO
    큐 길기 같다고 했고
    queue1 sum = queue2 sum
    두 큐의 합이 홀수이면 -1
    1,1  1,5 경우이면 -1
    이거 계속 보니까 배열 1열로 두고 투포인터로 움직이기
 */
public class PGS_MakeSumsOfTwoQueuesEqual {
    class Solution {
        public int solution(int[] queue1, int[] queue2) {
            // 두 큐의 길이 같다고 해서 하나로 만들어서 투포인터 쓸거임
            int n = queue1.length;
            int size = n * 2;

            // 큐를 하나의 배열로 합쳐두고
            long[] arr = new long[size];
            long sum1 = 0; // queue1 합
            long total = 0; // 두 큐 합

            // 배열 합쳐두고
            for (int i = 0; i < n; i++) {
                arr[i] = queue1[i];
                arr[i + n] = queue2[i];
                sum1 += queue1[i]; // queue1 합 받아두고
                total += queue1[i] + queue2[i]; // total 해서 받아두고
            }
            // 이제부터 투포인터 사용 가능하고

            // 전체 합이 홀수면 불가능 (전제 넣어주고)
            if (total % 2 != 0) return -1;

            // 절반 값 확인하고
            long target = total / 2;

            // 투포인터 사용하려고 넣어주고
            int left = 0;
            int right = n; // 여기서 부터 queue2
            int count = 0;

            // 이 무한루프 방지 강사님꺼 시원하게 gpt 돌려주고
            while (left < size && right < size && count <= size * 2) {
                //여기부터는 그냥 맞으면 넣어주고 아니면 비교하고
                if (sum1 == target) {
                    return count;
                } else if (sum1 < target) {
                    sum1 += arr[right];
                    right++;
                } else {
                    sum1 -= arr[left];
                    left++;
                }
                count++;
            }

            return -1;
        }
    }
}
