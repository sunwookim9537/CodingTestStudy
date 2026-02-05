class Solution {
    public int solution(String s) {
        int len = s.length();

        // 길이 1이면 압축 시도할 것도 없이 1
        if (len == 1) return 1;

        int best = len; // 압축 안 했을 때가 기본 상한

        // unit: 자를 단위 길이 (1 ~ len/2)
        for (int unit = 1; unit <= len / 2; unit++) {
            StringBuilder compressed = new StringBuilder();

            String prev = s.substring(0, unit);
            int count = 1;

            // i는 다음 chunk 시작 인덱스
            for (int i = unit; i < len; i += unit) {
                // 끝이 len을 넘을 수 있으니 min 처리 (마지막 남는 조각 대응)
                int end = Math.min(i + unit, len);
                String cur = s.substring(i, end);

                if (cur.equals(prev)) {
                    count++;
                } else {
                    // prev 확정 출력: count가 1이면 숫자 생략
                    if (count > 1) compressed.append(count);
                    compressed.append(prev);

                    // 새 그룹 시작
                    prev = cur;
                    count = 1;
                }
            }

            // 마지막 그룹 출력
            if (count > 1) compressed.append(count);
            compressed.append(prev);

            best = Math.min(best, compressed.length());
        }

        return best;
    }
}