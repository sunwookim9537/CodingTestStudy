import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0];    // 기본 시간 (분)
        int basicFee = fees[1];     // 기본 요금 (원)
        int unitTime = fees[2];     // 단위 시간 (분)
        int unitFee = fees[3];      // 단위 요금 (원)
        // fees = [180, 5000, 10, 600] 이렇게 되어있음

        // 1. 차량별 누적 주차 시간 추적 (해시맵)
        Map<String, Integer> totalTime = new HashMap<>(); // 차량번호 -> 누적 시간, "5961" → 145
        Map<String, Integer> inTime = new HashMap<>();    // 차량번호 -> 입차 시각(분), "5961" → 334
		
        // record 하나씩 처리 반복문
        for (String record : records) {
            String[] parts = record.split(" ");
            String timeStr = parts[0];
            String carNum = parts[1];
            String action = parts[2];

            // 2. 시각 문자열 -> 분 단위로 변환
            int time = convertTimeToMinutes(timeStr);

            if (action.equals("IN")) {
                inTime.put(carNum, time);
            } else {
                // 출차: 입차 시각 빼고 누적시간에 더함
                int inT = inTime.get(carNum);
                int parked = time - inT; // 이번에 주차한 시간
                totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + parked);
                // 기존에 누적 시간 있으면 그걸로, 없으면 0부터 시작 -> 둘이 더해서 저장
                inTime.remove(carNum); // 현재 주차중인 차량에서 제거
            }
        }

        // 3. 출차 없는 차량 처리 (23:59 출차)
        int endOfDay = 23 * 60 + 59;
        for (String carNum : inTime.keySet()) {
        // 아직 남아있는 차만 반복
            int inT = inTime.get(carNum);
            int parked = endOfDay - inT;
            totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + parked);
            // 23:59 까지 주차한 시간 추가
        }

        // 4. 차량 번호 오름차순 정렬 후 요금 계산
        List<String> carList = new ArrayList<>(totalTime.keySet());
        Collections.sort(carList);
		
        // 결과 담을 배열
        int[] answer = new int[carList.size()];
        int idx = 0;
        for (String carNum : carList) {
            int time = totalTime.get(carNum);
            int fee = basicFee;

            if (time > basicTime) {
                // 초과 시간 계산: Math.ceil 사용 (올림)
                fee += (int)Math.ceil((double)(time - basicTime) / unitTime) * unitFee;
            }

            answer[idx++] = fee;
        }

        return answer;
    }

    // 시각 문자열(HH:MM) -> 총 분 변환
    private int convertTimeToMinutes(String timeStr) {
        String[] hm = timeStr.split(":");
        int hour = Integer.parseInt(hm[0]);
        int minute = Integer.parseInt(hm[1]);
        return hour * 60 + minute;
    }
}