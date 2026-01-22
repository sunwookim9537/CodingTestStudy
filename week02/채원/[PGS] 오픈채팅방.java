import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
      
        
        // 닉네임을 변경하는 방법
        // 1.채팅방을 나가고 새로운 닉네임으로 들어오기 -> 기존에 들어있던 닉네임도 다 바뀜.
        // 2.채팅방에서 닉네임 변경 -기존에 있던 메세지의 닉네임도 전부 변경
        //중복 닉네임을 허용 
        //최종적으로 방을 개설한 사람이 보게 되는 메세지를 문자열 배열 형태로 RETURN
        // RECORD-> 닉네임을 변경한 기록이 담김 (1<=RECORD<=100,000)
        //모든 유저는 유저 아이디로 구분
        // ENTER [유저아이디][닉네임] => 유저아이디 사용자가 닉네임으로 채팅방에 입장
        // LEAVE 유저아이디 -? 유저 아이디 사용자가 채팅방에서 퇴장
        // CHANGEW 유저아이디 닉네임 -> 유저 아이디 사용자가 닉네임을 닉네임으로 변경
        // 첫번째 단어는 ENTER, LEAVE, CHANGE
        // 각 단어는 공백으로 구분되어져있고, 대문자, 소문자, 숫자로만 이루어져있다
        // 유저 아이디와 닉네임은 대문자 소문자를 구별함
        //아이디 , 닉네임의 길이는 1~10
        
        Map<String,String> name= new HashMap<>();
        
        //이렇게 해두고
         int cmp=0;
        for(String r: record){
            String[] tmp= r.split(" ");
            if(tmp[0].equals("Enter")){
                //입장이면 가지고 있는지 확인 , 가지고 있으면 닉네임 변경 or 없으면 추가
                if(name.containsKey(tmp[1])) name.replace(tmp[1],tmp[2]);
                else name.put(tmp[1],tmp[2]);
                cmp+=1;
                continue;
            }
            else if(tmp[0].equals("Change")){
                name.replace(tmp[1],tmp[2]);
                continue;
            }
            cmp+=1;
        }
        // 저장하기=>String으로 저장시 시간 초과 
        StringBuilder sb= new StringBuilder();

     
        for(String r: record){
            String[] tmp= r.split(" ");
            if(tmp[0].equals("Enter")){
                sb.append(name.get(tmp[1])+"님이 들어왔습니다."+"\n");
            
            }
            else if(tmp[0].equals("Leave")){
                sb.append(name.get(tmp[1])+"님이 나갔습니다."+"\n");
          
        }
        }
        return sb.toString().split("\n");
    }
}