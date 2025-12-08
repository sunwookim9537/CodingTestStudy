class Solution {
    public String solution(int n, int t, int m, int p) {
     //n: 진법 | t: 미리 구할 숫자의 개수(말해야하는 숫자) | m: 게임에 참가하는 인원 | p: 튜브의 순서(본인 )
        //출력은 6진수 방식으로 할것 
		
        String answer = "";
        StringBuilder tmp= new StringBuilder();
        //**1. n진법으로 받기 -> stringBuilder에 추가**//
        int i2=0;
       while(tmp.length()<m*t){ //chatgpt에게 힌트얻기-> 말해야하는 숫자인걸 나중에 알았음 
            //0번부터 받기

            String num=Integer.toString(i2,n);
           // System.out.println(num);
            for(int j=0; j<num.length(); j++){
            	if(tmp.length()==m*t) break;
            	else
                tmp.append(num.charAt(j));
               
            }
            i2+=1;
        }//한단어씩 쪼개서 넣기
     
       //System.out.println("tmp-"+tmp);
        //**2.게임에 참여하는 순서대로 본인이 말해야하는 걸 answer에 추가**//
        int index=p-1;
        
        for(int i=0; i<tmp.length(); i++){
           if(i==index){
        	  // System.out.println("index="+index+"~~"+(index+m));
               if(tmp.charAt(i)>=10 && tmp.charAt(i)<=15) {
            	   System.out.println("tl"+tmp.charAt(i));
            	   answer+=Integer.toString(Integer.valueOf(tmp.charAt(i)),6);
               }
               else answer+=tmp.charAt(i);
               index+=m;
           }
        }
        //대문자로 만들기 
        answer=answer.toUpperCase();
       return answer;
    }
}