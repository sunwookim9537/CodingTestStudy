import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        //뒷 큰수 :배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수
        //모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return
        //뒷 큰수가 존재하지 않는 원소는 -1을 담습니다
        
        /*
        
        */
        Stack<Integer> stack= new Stack<>();
        for(int i=0; i<numbers.length; i++){
            answer[i]=-1;
        
            while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]){
                answer[stack.pop()]= numbers[i];
            }
            stack.push(i);
        }
        
        return answer;
    }
}