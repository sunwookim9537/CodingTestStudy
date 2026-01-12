/*“각 숫자마다 내가 할 수 있는 선택은 몇 개지?”
→ `+` `-`  딱 2가지 → 선택지 반복 분기
“모든 경우를 다 만들어 보고, 그중 target인 것만 세자”

1. numbers는 순서를 바꾸면 안 됨
2. 각 숫자는 반드시 사용됨
3. 각 숫자마다 선택은 2가지 (+ / -)
4. 선택이 끝나는 시점은 numbers 끝
5. 그때 만들어진 합이 target인지 확인


“계산 문제가 아닌, 모든 선택 조합을 끝까지 만들어보는 문제" */

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0; // target num 만드는 전체 경우의 수(최종 답)
        answer = dfs(numbers, 0, 0, target); // dfs 호출,해당 반환값=경우의 수
        return answer;
    }
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) { // 종료 조건: 모든 숫자를 다 사용했을 때 (리프 노드)
            if(sum == target) { // 현재 경로의 합이 target이면
                return 1; // 이 경로의 유효한 경우의 수 = 1개
            }
            return 0; // target이 아니면 이 경로는 실패 (0개)
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
}

/*
class Solution {

    int count = 0; // target을 만드는 경우의 수

    public int solution(int[] numbers, int target) { //DFS 시작
        dfs(numbers, target, 0, 0); // index = 0 (첫 숫자)
        return count; //value = 0 (아직 아무것도 더하지 않음)
    }

    private void dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) { // 모든 숫자를 다 사용했을 때
            if (sum == target) { // 누적 값이 target이면 경우의 수 +1
                count++;
            }
            return; // 탐색 종료
        }

        dfs(numbers, target, index + 1, sum + numbers[index]);//현재숫자합경우
        dfs(numbers, target, index + 1, sum - numbers[index]);//현재숫자차경우
    }
}
*/