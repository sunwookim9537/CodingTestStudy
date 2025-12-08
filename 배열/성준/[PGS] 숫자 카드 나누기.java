package StudyCodingTest.Arr;

public class PGS_SplitCards {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // 테스트 케이스 1
        int[] arrayA1 = {10, 17};
        int[] arrayB1 = {5, 20};
        System.out.println("Result 1 = " + sol.solution(arrayA1, arrayB1)); // expected: 0

        // 테스트 케이스 2
        int[] arrayA2 = {10, 20};
        int[] arrayB2 = {5, 17};
        System.out.println("Result 2 = " + sol.solution(arrayA2, arrayB2)); // expected: 10

        // 테스트 케이스 3
        int[] arrayA3 = {14, 35, 119};
        int[] arrayB3 = {18, 30, 102};
        System.out.println("Result 3 = " + sol.solution(arrayA3, arrayB3)); // expected: 7
    }

    /*
       아 한국말 진짜 어렵네....그니까 공약수로 상대방 나눠지면 안된다는거잖아. 그래서 나눠지는 최대 숫자 고르라고 없으면 0이고
       근데 공약수 구하는게 뭐임? GPT -> GCD함수? 미친 ㄹㅇ 첨 보는건데 개빡치네
        하ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ유클리드 호제법이요? 이거 python에서 볼걸 여기서 다시 만나내 반갑다.
        ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ아니 이거 다시 gcd 야 개빡이네 하...1시간 넘게 보고 있는데....

        for문 사용해서 10 20 전부 다 돌려 보는건데 계속 에러 뜨는데... GG 칩니다. 이거 강의 봐야 될 거 같음.

        조건 1
            a가 철수 모든 숫자를 나누어야 한다.
            a가 영희의 숫자 중 단 하나도 나누어지면 안 된다.
        조건 2
            a가 영희 모든 숫자를 나누어야 한다.
            a가 철수 숫자 중 단 하나도 나누어지면 안 된다.
        -- 이말로 a는 무조건 1 이상이여야 하는거고
     */
    static class Solution {
        public int solution(int[] arrayA, int[] arrayB) {
            int answer = 0;
            return answer;
        }
    }
}
