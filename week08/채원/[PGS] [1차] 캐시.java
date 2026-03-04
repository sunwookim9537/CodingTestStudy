import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
      
        Deque<String> tmp = new ArrayDeque<>();
         int answer = 0;
      
        // 0 ≦ cacheSize ≦ 30 -> 캐쉬 사이즈가 0인경우에는 그냥 cities 사이즈 전체에 *5?
        if(cacheSize==0) return cities.length*5;
        for(String c: cities){
            String city= c.toUpperCase();
            
            if(tmp.contains(city)){
                answer+=1;
                tmp.remove(city);
                tmp.addLast(city); // addLast;
            }
            else {
                // 차있을 경우에는 앞에껄 삭제한다.
                if(tmp.size()>= cacheSize) tmp.pollFirst(); //pullFirst
                
                tmp.addLast(city);
                answer+=5;
                
            }
        }
       
        return answer;
    }
}