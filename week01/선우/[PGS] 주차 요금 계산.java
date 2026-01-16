import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

class Solution {
   public int[] solution(int[] fees, String[] records) {

        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();

        // 1. 기록 처리
        for (int i = 0; i < records.length; i++) {
            String[] r = records[i].split(" ");
            int time = toMinute(r[0]);
            String car = r[1];
            String type = r[2];

            if (type.equals("IN")) {
                inTime.put(car, time);
            } else { // OUT
                int in = inTime.get(car);
                int diff = time - in;
                totalTime.put(car, totalTime.getOrDefault(car, 0) + diff);
                inTime.remove(car);
            }
        }

        // 2. 출차 안 한 차량 → 23:59 처리
        int end = toMinute("23:59");
        for (String car : inTime.keySet()) {
            int diff = end - inTime.get(car);
            totalTime.put(car, totalTime.getOrDefault(car, 0) + diff);
        }

        // 3. 차량 번호 정렬
        List<String> cars = new ArrayList<>(totalTime.keySet());
        Collections.sort(cars);

        // 4. 요금 계산
        int[] answer = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            int time = totalTime.get(cars.get(i));
            answer[i] = moneyCheck(fees, time);
        }

        return answer;
    }

    // HH:MM → 분
    public int toMinute(String t) {
        String[] s = t.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }

    // 요금 계산
    public int moneyCheck(int[] fees, int time) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (time <= baseTime) {
            return baseFee;
        }

        int extra = time - baseTime;
        int units = (int) Math.ceil((double) extra / unitTime);
        return baseFee + units * unitFee;
    }
}