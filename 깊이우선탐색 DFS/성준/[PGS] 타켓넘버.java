package studycodingtest.dfs;
/*
    1 +- 하면 2^20 번
    numbers 와 target 은 담아 두고 시작
 */
public class PGS_targetNumber {
    static class Solution {
        int[] numbers;
        int target;
        int answer;
        void dfs(int index, int sum){
            // 탈출
            if(index==numbers.length){
                if(sum==target){
                   answer++;
                }
                return;
            }
            // 수행
            // 누접합에 현재 index 숫자를 더해 빼
            dfs(index+1, sum + numbers[index]);
            dfs(index+1, sum - numbers[index]);
        }
        public int solution(int[] numbers, int target) {
            answer = 0;

            dfs(0,0);

            return answer;
        }
    }
}
