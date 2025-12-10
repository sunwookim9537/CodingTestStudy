class Solution {
    //이문제는 솔직히 제실력대로 푼 문제가 아니라 
    //공부가 많이 필요할거같습니다 .
    //gcd 알고리즘 공부
    //https://www.youtube.com/watch?v=VvHHj3x9oZg&t=230s
    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
	/*a를 b로 나눈 나머지와 b를 반복해 구하다보면 나머지가 0이되는 순간이 최대공약수이다. => 갯수가 m, 숫자의 크기에 따라  횟수가 반복하다보면 log m이되는데 배열의 갯수가 n이므로 (n*log m)*/
    }
    public static int gcdArray(int[]array){//구글링...
        int a=array[0];
        for(int i=1; i<array.length;i++){
	
            a=gcd(a,array[i]);
            if(a==1) return 1; //1은 모든 공약수
        }
        return a;
         }
    public int solution(int[] arrayA, int[] arrayB) {
        boolean checkA=true;
        boolean checkB=true;
        int answer = 0;
       
        //arrayAB에서 최대 공약수를 찾기 =>gcb
        //구글링 했습니다.
        int tmaxA=gcdArray(arrayA);
        
        int tmaxB=gcdArray(arrayB);
        //여기서 tmaxA와 tmaxB가 두번 하기 때문에 (각각 a의 배열길이 -a / b의 배열 길이 (a+b)*log M이된다
        //나눠지면 0/ 안나눠지면 answer에 넣기
        for(int i=0; i<arrayA.length; i++){
            if(arrayA[i]!=0){
            if(arrayA[i]%tmaxB==0){
                checkA=false;
                break;
            }
            }
        }
        
        //나눠지면 0/ 안나눠지면 answer에 넣기
        for(int i=0; i<arrayB.length; i++){
            if(arrayB[i]!=0){
            if(arrayB[i]%tmaxA==0){
                
                checkB=false;
                break;
            }
            }
        }
        if(checkA==true) answer=tmaxA;
        if(checkB==true) answer=Math.max(tmaxB,tmaxA);
        return answer;
    }
}