import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {

        // 1) 귤 크기별로 개수를 저장할 Map
        Map<Integer, Integer> countMap = new HashMap<>();

        // 2) 배열을 돌면서 크기별 개수 세기
        for (int size : tangerine) {

            if (countMap.containsKey(size)) {
                countMap.put(size, countMap.get(size) + 1);
            } else {
                countMap.put(size, 1);
            }
        }

        // 3) Map의 value(개수)만 배열로 옮기기
        int[] counts = new int[countMap.size()];
        int index = 0;
        for (int v : countMap.values()) {
            counts[index++] = v;
        }

        Arrays.sort(counts);    // 4) 개수 배열 정렬

        // 5) 큰 개수부터 더해가며 k개 채우기
        int sum = 0;
        int types = 0;

        for (int i = counts.length - 1; i >= 0; i--) {
            sum += counts[i];
            types++;

            if (sum >= k) break;
        }

        return types;
    }
}