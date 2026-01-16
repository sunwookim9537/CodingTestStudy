class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        //양의 정수 n 
        // k진수 -> 소수가 몇개인지 알아보려한다
        // int vs long 기준표
        //long을 써야하는 경우 -> 입력제한이 10^9이상인 경우 1,000,000,000
        //곱셈/제곱 /누적합이 등장할때 long의심 
        // 진법 변환/문자열 숫자 처리 할때는 long 기본 선택 
        //소수 판별/ 거리 계산/ 좌표 계산 
        //코테에서 안 헷갈리는 습관 ->
        //1) 곱셈보이면 long,| 2) 문자열 -> 숫자= long |3) 소수 판별은 전부 long
        //0p0 / p0 / 0p /p => 단 p는 각 자릿수에 0을 포함하지 않는 소수 
        //k진법으로 보았을 때가 아닌 10진법으로 보았을때 소수여야 한다.
        //211 -> p0 | 2-> 020 | 11 -> 0p
        //정수 n과 k가 매개변수로 주어짐 
        // n을 k진수로 바꿨을 때 변환된 수안에서 찾을 수 있는 소수의 개수를 return 할 것
        
        //진법으로 바꾸기 
        String[] finalNk= Integer.toString(n,k).split("0");
        //Long finalNk= Long.parseLong(n,k);
        
        //변환된 수 안에서 찾을 수 있는 소수의 개수 찾기
        for(int i=0; i<finalNk.length; i++){
            if(finalNk[i].isEmpty()) continue;
            long tmp=Long.parseLong(finalNk[i]);//!!! 10진법으로 보았을 때 소수여야해서 10진수로 해석하면 안됨.
            if(tmp<2) {
                continue;
            }
            boolean prime= true;
            //1번 11번 런타임 에러 ->chatGPT (또 다른 런타임/시간 문제: 소수 판별이 너무 느림 (시간 초과))
            //√tmp까지만 검사해야함. 하지만 테스트1 실패 -> 시간 초과 왜 ? long으로 안해서 !!!
            //기본 소수 판별 틀 
            /*
              if (n < 2) return false;

             for (long i = 2; i * i <= n; i++) {
                if (n % i == 0) return false;
                }
              return true;
            */
            for(long i2=2; i2 * i2 <= tmp; i2++){
                
                if(tmp%i2==0){
                    prime=false;
                    break;
                } 
                
                
            }
          if(prime==true)  answer+=1;
        }
        
        
        return answer;
    }
}