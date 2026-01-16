import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        //k=k번 이상 신고당하면 이용 정지 
        //id_list= 전체 유저 목록 
        //report = 이용자 id 신고한 id => 이용자 id가 frodo를 신고했다 
        /* 각 유저는 한 번에 한 명의 유저를 신고할 수 있습니            다. 
        신고 횟수에 제한은 없습니다.
          서로 다른 유저를 계속해서 신고할 수 있습니다. 한 유저를 여러 번 신고할 수도 있지만, 
          동일한 유저에 대한 신고 횟수는 1회로 처리됩니다. 
          */
        
        // 중복 제거==> set 중요 ㅠㅠ
        Set<String> uniqueReport = new HashSet<>(Arrays.asList(report));

        // 신고대상 누적 채우기 
        Map<String, Integer> reportCount = new HashMap<>();
        for (String r : uniqueReport) {
            String[] tmp = r.split(" ");
            String reported = tmp[1];
            reportCount.put(reported, reportCount.getOrDefault(reported, 0) + 1);
        }

        // 신고 대상 구하기 (k이상인경우)
        Set<String> banned = new HashSet<>();
        for (String user : reportCount.keySet()) {
            if (reportCount.get(user) >= k) {
                banned.add(user);
            }
        }

        // 4. 메일 수 집계
        Map<String, Integer> mail = new HashMap<>();
        for (String r : uniqueReport) {
            String[] tmp = r.split(" ");
            String reporter = tmp[0];
            String reported = tmp[1];

            if (banned.contains(reported)) {
                mail.put(reporter, mail.getOrDefault(reporter, 0) + 1);
            }
        }

        // 5. 정답 배열 생성
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mail.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}
