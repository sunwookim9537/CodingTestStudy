import java.util.*;
class Solution {
    /*
    폰켓몬 n개마리 중에서 n/2마리를 가져가도됨. 다양한 종류를 가져가고 싶어함
    
    1. 종류에 따라 번호를 붙여 구분 (같은종류의 폰켓몬은 같은 번호를 가지고 있음)
    2. 예시 ) 3,1,2,3번 -> 4마리이면 2마리를 가져가도 됨 
    (3,1) (3,2) (3,3) (1,2) (1,3) (2,3)
    --> 3번과 3번은 같은 종류이므로(중복 X) 1종류, 나머지는 2종류이므        로 최대 2가 됨 
    3. 최대한 다양한 종류의 폰켓몬을 가진 최댓값을 return
    4. nums-> 1차원 배열 / 1<=N<=10000(항상 짝수로 주어짐)
    5. 1<= 종류번호 <=200000
    6. 선택할 수 있는 폰켓몬 종류 개수의 최대값 하나만 return 
    */
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> pokemon=new HashSet<>();
        for(int i: nums){
            if(!pokemon.contains(i)){
                pokemon.add(i);
            }
        }
        return Math.min(pokemon.size(),nums.length/2);
    }
}