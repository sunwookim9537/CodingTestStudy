
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int len = tangerine.length;

        for (int i = 0; i < len; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }


        int size = map.size();

        // 모양별로 갯수만 배열에 저장해서 내림차순으로 바꾸고 더해가면서 k 보다 커질떄까지 카운트
        Integer arr[] = map.values().toArray(new Integer[0]);
        Arrays.sort(arr, Collections.reverseOrder());

        int sum = 0;
        for (int cnt : arr) {
            sum += cnt;
            answer++;
            if (sum >= k) {
                break;
            }
        }

        return answer;
    }
}
