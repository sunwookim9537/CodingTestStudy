class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int tmp=0; //현재위치
        boolean rightValue=true;
        for(String s: skill_trees){//1
            rightValue=true;
            tmp=0;
            for(int i=0; i<s.length(); i++){//2
                String r= String.valueOf(s.charAt(i));
                for(int i2=0; i2<skill.length(); i2++){//3
                    String b= String.valueOf(skill.charAt(i2));
                
                    if(i2<tmp){
                        //이전의 내용이라면
                        if(r.equals(b)){
                           // System.out.println(r+"현재 걸림:"+i2+"//"+b);
                             rightValue=false;
                            break;
                        }
                    }
                    else if(i2==tmp){
                        //같은경우
                        if(r.equals(b)){
                           // System.out.println(r+"/?"+i2);
                            tmp+=1;
                        }
                    }
                    else if(i2>tmp){
                        //큰 경우
                          if(r.equals(b)){
                            //  System.out.println(r+"현재 걸림:"+i2+"//"+b);
                               rightValue=false;
                            break;
                        }
                    }
                    
                }
                
            }
            System.out.println(s);
            if(rightValue==true) answer+=1;
        }
        return answer;
    }
}