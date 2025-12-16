import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {

        // 1) 두 큐를 실제 Queue로 만든다 (front pop / back insert 그대로 구현 가능)
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();

        // 2) 합은 long으로 관리 (원소가 최대 1e9, 길이 3e5 => int overflow 가능)
        long sum1 = 0;
        long sum2 = 0;

        for (int x : queue1) {
            q1.offerLast(x);
            sum1 += x;
        }
        for (int x : queue2) {
            q2.offerLast(x);
            sum2 += x;
        }

        long total = sum1 + sum2;

        // 3) 전체 합이 홀수면 반으로 정확히 나눌 수 없으므로 불가능
        if (total % 2 != 0) return -1;

        long target = total / 2;

        // 4) 무한 루프 방지용 제한
        // 보통 n*3 정도면 충분히 안전하게 "불가능"을 판정한다.
        int n = queue1.length;
        int limit = n * 3;

        int count = 0;

        // 5) sum1을 target으로 맞추는 과정
        // sum1이 크면 q1에서 빼서 q2로 보내고
        // sum1이 작으면 q2에서 빼서 q1로 보낸다.
        while (count <= limit) {

            // 목표 달성
            if (sum1 == target) return count;

            if (sum1 > target) {
                // q1의 front를 pop해서 q2의 back에 insert
                int x = q1.pollFirst();
                sum1 -= x;
                sum2 += x;
                q2.offerLast(x);
            } else {
                // sum1 < target 이면 q2에서 꺼내 q1으로 보냄
                int x = q2.pollFirst();
                sum2 -= x;
                sum1 += x;
                q1.offerLast(x);
            }

            count++;
        }

        // limit 내에 못 맞추면 불가능
        return -1;
    }
}