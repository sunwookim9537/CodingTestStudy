class Solution {
    static int cnt=0;
    static void dfs(int[] numbers, int target,int n,int sum){
      
        //조건에 부합하는지 확인 
        if(n==numbers.length){
            if(sum==target) cnt+=1;
            return;
        }
        //2가지 방법이 주어짐 -1 /+1
        dfs(numbers,target,n+1,sum-numbers[n]);
        dfs(numbers,target,n+1,sum+numbers[n]);
        
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        /*사용할 수 있는 숫자가 담긴 배열 numbers, 
        타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 
        타겟 넘버를 만드는 방법의 수를 return*/
       // int[] visit= new int[numbers.length];
        dfs(numbers,target,0,0);
        answer=cnt;
        return answer;
    }
}