import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = -1;

        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();


        //오른쪽에 몰아넣고 왼쪽에 하나씩 옮기면서 갯수 비교
        for(int s:topping){
            right.put(s, right.getOrDefault(s, 0) + 1);
        }
        int cnt=0;

        for (int i = 0; i < topping.length; i++) {
            int curr = topping[i];
            left.put(curr, left.getOrDefault(curr, 0) + 1);
    
            
            //오른쪽에서 제거할지 숫자 줄일지 
            int rightCnt = right.get(curr)-1;
            if(rightCnt == 0){
                right.remove(curr);
            }else{
                right.put(curr, rightCnt);
            }
            
            //비교했을떄 같으면 카운트
            if(left.size() == right.size()){
                cnt++;
            }



        }


        return cnt;

    }
}