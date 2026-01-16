import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        // 1. 신고당한 사람 → 신고한 사람들
        Map<String, Set<String>> reportedBy = new HashMap<>();

        // 모든 유저를 미리 Map에 넣어둔다
        for (String id : id_list) {
            reportedBy.put(id, new HashSet<>());
        }

        // 2. 신고 기록 처리
        for (String r : report) {
            // "muzi frodo" → ["muzi", "frodo"]
            String[] parts = r.split(" ");
            String from = parts[0]; // 신고한 사람
            String to = parts[1];   // 신고당한 사람

            // Set이라서 중복 신고 자동 제거
            reportedBy.get(to).add(from);
        }

        // 3. 정지된 사람 찾기
        Set<String> banned = new HashSet<>();

        for (String user : reportedBy.keySet()) {
            // 신고한 사람 수가 k 이상이면 정지
            if (reportedBy.get(user).size() >= k) {
                banned.add(user);
            }
        }

        // 4. 결과 배열 (id_list 순서대로)
        int[] answer = new int[id_list.length];

        // id_list 순서 보존을 위해 인덱스 사용
        for (int i = 0; i < id_list.length; i++) {
            String me = id_list[i];

            // 내가 누구를 신고했는지 다시 확인
            for (String bannedUser : banned) {
                if (reportedBy.get(bannedUser).contains(me)) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}