class Solution {
    public String solution(int n, int t, int m, int p) {

        // 1. 전체 게임에서 말해지는 모든 문자들을 저장할 StringBuilder
        StringBuilder total = new StringBuilder();

        int num = 0;  // 0부터 숫자를 만들어 n진수로 변환할 것

        // 2. 튜브가 t개 말할 수 있을 만큼 전체 글자를 만들어야 한다 (최소 m * t 글자)
        while (total.length() < t * m) {

            // (1) num을 n진수 문자열로 변환
            // Integer.toString(num, n) => 진법 변환
            String converted = Integer.toString(num, n).toUpperCase();

            // (2) 변환된 문자열을 전체 문자열에 이어 붙인다
            // 예: 2 → "10" → '1','0' 순서대로 붙음
            total.append(converted);

            num++; // 다음 숫자로 이동
        }


        // 3. 튜브(p번째 사람)가 말해야 하는 글자만 뽑기
        StringBuilder answer = new StringBuilder();

        // p는 1부터 시작하지만, 인덱스는 0부터이므로 p-1이 튜브 첫 차례
        int index = p - 1;

        // 4. 튜브가 t글자를 말할 때까지 반복
        while (answer.length() < t) {

            // total에서 (튜브 차례의 인덱스)에 해당하는 문자 뽑기
            char speak = total.charAt(index);

            // answer에 추가
            answer.append(speak);

            // 다음 튜브 차례는 사람 수 m만큼 뒤
            index += m;
        }

        // 5. 완성된 정답 문자열 출력
        return answer.toString();
    }
}