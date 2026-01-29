import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {

        // 1. 폰켓몬 종류를 저장할 Set
        Set<Integer> kinds = new HashSet<>();

        // 2. 모든 폰켓몬 종류 추가
        for (int num : nums) {
            kinds.add(num);
        }

        // 3. 선택 가능한 최대 수 = N / 2
        int maxSelect = nums.length / 2;

        // 4. 종류 수 vs 선택 가능 수 중 작은 값
        return Math.min(kinds.size(), maxSelect);
    }
}