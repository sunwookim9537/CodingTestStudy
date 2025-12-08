import java.util.*;
class Solution {
    public String solution(String[] participation, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>(); //
        for(int i = 0 ;i<participation.length;i++){
            if(map.containsKey(participation[i])){ //키값을 가지고있따면 
                map.put(participation[i],map.getOrDefault(participation[i],0)+1);
                
            }
            else{
                map.put(participation[i],1);  //없으면 1로 
            }
            
    
        }  
        // 중복체크를 어떻게 할까
        
        
    
        
        for(int i = 0 ;i<completion.length;i++){ 
            if(map.containsKey(completion[i])){ //야호 ! 키값을 가지고있다면 
                map.put(completion[i],map.getOrDefault(completion[i],0)-1); //하나줄여 ! 
                
            }
        }
        
        for(String key : map.keySet()){ 
            if(map.get(key) == 1){  //하나 남아있는게 완주한 것 
                answer = key;
                
            }
        }
        
        return answer;
        
      
        
        
    }
}