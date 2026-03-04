import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        List<String> cache = new ArrayList<>();

        // 캐시 크기가 0이면 전부 없는거니까
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            city = city.toLowerCase(); // 대소문자 무시

            // 리스트에 도시가 있다면
            if (list.contains(city)) {
                // list hit
                time += 1;
                list.remove(city);   // 기존 위치 제거
                list.add(city);      // 맨 뒤에 추가 (최근 사용)
            } else {
                // 리스트에 도시가 없다면
                time += 5;

                if (list.size() == cacheSize) {
                    list.remove(0);  // 가장 오래된 것 제거
                }

                list.add(city);      // 새 도시 추가
            }
        }
        return time;
    }
}