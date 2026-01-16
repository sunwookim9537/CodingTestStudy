import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // Step 0. 결과 배열과 인덱스 매핑/결과는 id_list 순서대로 반환해야 하므로
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            indexMap.put(id_list[i], i);
        }

        int[] result = new int[id_list.length];

        // Step 1. 중복 신고 제거
        Set<String> uniqueReport = new HashSet<>();

        for (String r : report) {
            uniqueReport.add(r); // 이미 있으면 자동으로 무시
        }

        // Step 2. 누가 누구를 신고했는지 정리 (신고자 기준)
        // -------------------------------
        // 신고자 -> 신고한 대상들의 집합
        Map<String, Set<String>> reportMap = new HashMap<>();
        
        for (String r : uniqueReport) {
            // "신고자 신고대상" 분리
            String[] parts = r.split(" ");
            String reporter = parts[0];
            String target = parts[1];
            // 신고자가 처음 등장했다면 Set 생성
            reportMap.putIfAbsent(reporter, new HashSet<>());
            // 신고 대상 추가 (Set이라 중복 자동 제거)
            reportMap.get(reporter).add(target);
        }
        
        // Step 3. 신고당한 횟수 집계 (대상 기준)
        // -------------------------------
        // 대상 -> 신고당한 횟수
        Map<String, Integer> reportedCount = new HashMap<>();
        
        for (String reporter : reportMap.keySet()) {
            for (String target : reportMap.get(reporter)) {
                // target이 신고당한 횟수 +1
                reportedCount.put(
                        target,
                        reportedCount.getOrDefault(target, 0) + 1
                );
            }
        }

        // Step 4. 정지 대상 필터링 [k번 이상 신고당한 사람]
        Set<String> banned = new HashSet<>();
        for (String user : reportedCount.keySet()) {
            if (reportedCount.get(user) >= k) {
                banned.add(user);
            }
        }
        // Step 5. 신고자 기준으로 메일 수 계산 [신고한 사람들 중 정지된 사람 수]
        for (String reporter : reportMap.keySet()) {
            int idx = indexMap.get(reporter);
            for (String target : reportMap.get(reporter)) {
                if (banned.contains(target)) {
                    result[idx]++;
                }
            }
        }
        return result;
    }
}