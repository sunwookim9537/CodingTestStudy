import java.util.HashMap;

class Solution {

    public String solution(String[] participant, String[] completion) {

        // 1. 이름과 등장 횟수를 저장할 HashMap 생성
        //    key   : 선수 이름 (String)
        //    value : 그 이름을 가진 사람 수 (Integer)
        HashMap<String, Integer> map = new HashMap<>();

        // 2. 참가자 배열을 돌면서 HashMap에 등장 횟수 기록
        for (int i = 0; i < participant.length; i++) {
            String name = participant[i];  // i번째 참가자 이름

            if (map.containsKey(name)) {    // 이미 map에 같은 이름이 있으면
                int count = map.get(name);    // 현재까지 저장된 인원 수를 꺼내서
                map.put(name, count + 1);    // 1명 추가
            } else {
                map.put(name, 1);    // 처음 나오는 이름이면 1명으로 등록
            }
        }

        // 3. 완주자 배열을 돌면서 HashMap에서 인원 수를 줄이기
        for (int i = 0; i < completion.length; i++) {
            String name = completion[i]; // i번째 완주자 이름
            int count = map.get(name);    // 이 이름의 현재 남은 인원 수 가져오기
            count = count - 1;    // 한 명이 완주했으므로 1 감소

            if (count == 0) {
                map.remove(name);    // 더 이상 남은 사람이 없으면 HashMap에서 제거
            } else {
                map.put(name, count);  // 아직 남은 사람이 있다면 줄어든 값으로 다시 저장
            }
        }

        // 4. HashMap에 마지막으로 남아 있는 이름이 완주하지 못한 선수
        String answer = "";

        // map에는 key가 1개만 남아 있으므로,
        // keySet()으로 꺼낸 첫 번째 이름이 정답
        for (String name : map.keySet()) {
            answer = name;
            break;
        }

        return answer;
    }
}