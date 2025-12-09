import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] topping) {

        int answer = 0;

        Map<Integer, Integer> rightMap = new HashMap<>();
        Map<Integer, Integer> leftMap  = new HashMap<>();

        // 1. 처음에 오른쪽에 전체 토핑 개수 넣기
        for (int t : topping) {
            rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
        }

        // 2. 한 조각씩 왼쪽으로 옮겨 가며 자르는 위치 확인
        for (int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];

            // 오른쪽에서 t 하나 빼기 (무조건 get, null 안 됨)
            rightMap.put(t, rightMap.get(t) - 1);

            // 0이 되면 종류 삭제
            if (rightMap.get(t) == 0) {
                rightMap.remove(t);
            }

            // 왼쪽에 t 하나 추가
            leftMap.put(t, leftMap.getOrDefault(t, 0) + 1);

            // 종류 수 비교
            if (rightMap.size() == leftMap.size()) {
                answer++;
            }
        }

        return answer;
    }
}