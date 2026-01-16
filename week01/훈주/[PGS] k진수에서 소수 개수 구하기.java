class Solution {

    public int solution(int n, int k) {
        int count = 0;
        // 0 기준 분리, 양옆 조건 처리 위해 문자열 변환
        String baseK = Integer.toString(n, k);
        // 0 기준 분리(P후보):0P0, P0, 0P, P 조건 모두 자동 만족
        String[] parts = baseK.split("0");
        
        // 각 숫자 조각 선형 순회
        // 이미 만들어진 데이터 앞부터 끝까지 한 번씩만 검사
        for (String part : parts) {
            // 빈 문자열 제거
            // 연속된 0 때문에 split 결과에 "" 생길 수 있음
            if (part.equals("")) {
                continue;
            }

            // Step 3) P 조건 검사
            // - 0 포함 금지 조건은 split("0")으로 충족
            
            // Step 4) 10진수 기준 소수 판별
            // - k진수 해석이 아니라
            //  "문자열을 10진수 숫자로" 변환 후 소수 검사
            long num = Long.parseLong(part);

            // 조건 반영[중복 소수도 위치가 다르면 각각 카운트]
            if (isPrime(num)) { //소수 여부 판별
                count++;
            }
        }
        return count;
    }
    // 소수 판별 함수 (Condition Checking)
    // - 현재 값이 소수인지 여부만 판단
    // - 미래 선택이나 경우의 수 탐색 없음
    private boolean isPrime(long n) {
        if (n < 2) { // 1은 소수가 아님
            return false;
        }
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) { // 2부터 √n까지만 검사
                return false;
            }
        }
        return true;
    }
}