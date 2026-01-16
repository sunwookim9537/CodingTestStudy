package studycodingtest.week;

import java.util.*;

/*
    신고 회수 제한 x
    동일한 유저 신고 1회 => 유저,신고당한유저 한쌍으로 움직여 => 중복 제거 HashSet  함수
    HashSet vs TreeSet
    HashSet 정렬 X, TreeSet은 정렬 o
    시간복잡도 O(1), TreeSet O(long N)
    k번 이상 신고된 유저 게시판 이용 정지 -> 메일 발송

    id_list : 사용자 목록
    report : 신고 기록
    k : 정지 횟수
 */
public class week01_1 {
    public static void main(String[] args) {

        class Solution {
            public int[] solution(String[] id_list, String[] report, int k) {

                // 결과 배열 (id_list 순서 유지)
                int[] answer = new int[id_list.length];

                // 중복 신고 제거
                Set<String> uniqueReports = new HashSet<>(Arrays.asList(report));

                // 3. 신고당한 유저 -> 신고자 Set
                Map<String, Set<String>> reportedMap = new HashMap<>();

                // 신고한사람, 신고당한사람 담아
                for (String r : uniqueReports) {
                    String[] parts = r.split(" ");
                    String reporter = parts[0];
                    String reported = parts[1];

                    if (!reportedMap.containsKey(reported)) {
                        // 아직 이 사람이 신고당한 적이 없다면
                        reportedMap.put(reported, new HashSet<String>());
                    }

                    // 있으면 추가
                    reportedMap.get(reported).add(reporter);
                }

                //  유저 메일 0으로 시작
                Map<String, Integer> mailCount = new HashMap<>();
                for (String id : id_list) {
                    mailCount.put(id, 0);
                }

                // 정지 대상 처리
                for (String reported : reportedMap.keySet()) {
                    Set<String> reporters = reportedMap.get(reported);

                    if (reporters.size() >= k) {
                        for (String reporter : reporters) {
                            mailCount.put(
                                    reporter,
                                    mailCount.get(reporter) + 1
                            );
                        }
                    }
                }

                // 결과 배열에 반영 (id_list 순서대로)
                for (int i = 0; i < id_list.length; i++) {
                    answer[i] = mailCount.get(id_list[i]);
                }

                return answer;
            }
        }
    }
}

