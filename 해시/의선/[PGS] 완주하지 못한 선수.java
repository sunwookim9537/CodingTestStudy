import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        //정렬
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0;i<completion.length;i++){
            // 같은 위치에 같은게 아니면 완주자에 없는게 참여자에 들어있음
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }





        return participant[participant.length-1];

    }
}