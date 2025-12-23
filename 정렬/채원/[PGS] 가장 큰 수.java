import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        //정답이 너무 클 수 있으니 문자열로 바꾸어 return
        String[] stringArr= new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            stringArr[i]= String.valueOf(numbers[i]);
        }
               
              //CompareTo+ 람다식 사용
        // ?????????????????왜 뒤집히지...?
        //(a+b).compareTo(b+a) => a 가 b보다 작으면 a를 앞으로 둔다 즉 반대로
        Arrays.sort(stringArr,(a,b)->(b+a).compareTo(a+b)      );
        StringBuilder sb= new StringBuilder();
        
        
        boolean check0=false;
        for (int i=0; i<stringArr.length; i++){
            if(check0==false)
                if(!"0".equals(stringArr[i])){
                    //0이 아닌경우
                    check0=true;
            }
            
            sb.append(stringArr[i]);
        }
     
           //test case 11번만 틀리는 이유:
            /*
            입력값 => [0, 0, 0]
            기댓값 => "0"
            배열 요소가 모두 0인 경우 처리해주셔야합니다.
            */
        if(check0==false) return "0";
      
        //전체다 0이 아니라면
        answer=sb.toString();
        
        return answer;
     
        
    }
}