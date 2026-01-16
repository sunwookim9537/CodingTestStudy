

import java.util.Arrays;

class Solution {

	  public int solution(int n, int k) {
	        // 1. n을 k진수 문자열로 변환
	        String s = Integer.toString(n, k); // k 진법으로 나타내는 메서드 

	        // 2. 0 기준으로 분리
	        String[] parts = s.split("0");

	        int cnt = 0;

	        // 3.  for문
	        for (int i = 0; i < parts.length; i++) {
	            if (parts[i].equals("")) continue;

	            long num = Long.parseLong(parts[i]); // long으로 안전 파싱 안할 경우 너무 길어져서 에러 뜸 .
	            if (isPrime(num)) {
	                cnt++;
	            }
	        }

	        return cnt;
	    }

	    // 소수 판별 (long)
	    private boolean isPrime(long x) {
	        if (x <= 1) return false;
	        if (x == 2) return true;       // 2인 경우만 나눠서 받음 짝수인 유일한 소수
	        if (x % 2 == 0) return false;

	        for (long i = 3; i * i <= x; i += 2) {
	            if (x % i == 0) return false;
	        }
	        return true;
	    }
}