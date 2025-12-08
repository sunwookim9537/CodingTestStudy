class Solution {

    public int solution(int[] arrayA, int[] arrayB) {

        // 1. 철수 기준으로 가능한 후보 a (arrayA의 gcd 사용)
        int candidateFromA = getCandidate(arrayA, arrayB);

        // 2. 영희 기준으로 가능한 후보 a (arrayB의 gcd 사용)
        int candidateFromB = getCandidate(arrayB, arrayA);

        // 3. 둘 중 더 큰 값이 최종 정답
        return Math.max(candidateFromA, candidateFromB);
    }

    /**
     * dividesAll 배열의 모든 원소를 나누는 수 중 가장 큰 수 g를 구하고
     * 그 g가 dividesNone 배열의 어느 원소도 나누지 못하면 g를 리턴,
     * 하나라도 나누면 0을 리턴한다.
     *
     * 즉, "이 배열은 전부 나누고 / 저 배열은 하나도 못 나누는" 최대 수를 돌려줌.
     */
    private int getCandidate(int[] dividesAll, int[] dividesNone) {

        // 1. dividesAll 배열 전체의 최대공약수 구하기
        int g = gcdArray(dividesAll);

        // 2. g가 dividesNone의 어떤 원소도 나누지 못하는지 검사
        for (int i = 0; i < dividesNone.length; i++) {
            if (dividesNone[i] % g == 0) {
                // 하나라도 나누게 되면 "하나도 나누지 못한다" 조건 깨짐
                return 0;
            }
        }

        // 3. 조건을 통과하면 g가 후보 a
        return g;
    }

    /**
     * 배열 전체의 gcd를 구하는 메서드
     * 예) [10, 20, 30] → gcd = 10
     */
    private int gcdArray(int[] arr) {
        int g = arr[0];  // 첫 번째 원소로 시작
        for (int i = 1; i < arr.length; i++) {
            g = gcd(g, arr[i]);  // 앞서 만든 gcd 메서드 사용
        }
        return g;
    }

    /**
     * 두 정수 a, b의 최대공약수를 구하는 메서드
     * 유클리드 호제법 사용
     */
    private int gcd(int a, int b) {
        // b가 0이 될 때까지 나머지를 반복해서 구함
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        // b가 0이 되었을 때의 a가 gcd
        return a;
    }
}

/*
class Solution {

    public int solution(int[] arrayA, int[] arrayB) {

        // 철수 기준 GCD 후보
        int gcdA = gcdArray(arrayA);
        int candidateA = checkCandidate(gcdA, arrayB);

        // 영희 기준 GCD 후보
        int gcdB = gcdArray(arrayB);
        int candidateB = checkCandidate(gcdB, arrayA);

        // 둘 중 큰 값이 정답
        if (candidateA > candidateB) {
            return candidateA;
        } else {
            return candidateB;
        }
    }

    // 배열 전체의 GCD 구하기
    int gcdArray(int[] arr) {
        int g = arr[0];  // 첫 번째 값으로 초기화

        for (int i = 1; i < arr.length; i++) {
            g = gcd(g, arr[i]);   // 두 수의 GCD를 구해 g 업데이트
        }
        return g;
    }

    // 두 정수의 GCD(최대공약수)
    int gcd(int a, int b) {
        // 유클리드 호제법: a % b 반복 → b가 0 되면 a가 정답
        while (b != 0) {
            int temp = a % b;  // 나머지 저장
            a = b;             // b를 a에 저장
            b = temp;          // 나머지를 b로 이동
        }
        return a; // b가 0일 때의 a가 GCD
*/