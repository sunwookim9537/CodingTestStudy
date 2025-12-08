class Solution {
    //행렬은 대학교 들어가서도 많이 어려워했는데
    //처음에 개념이 기억이 안나서 챗지피티한테
    //행렬 누적합에 대해서 힌트만 달라고 했었습니다 ㅎ...
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        int index=0; //arr1의 인덱스
        int index2=0; //arr2의 인덱스
        
        //행렬의 곱
        //a= a1*a2
        //b=a2*b1;
        //c= a1*b1;
        //3중 for문
        //1.a의 a1
        //2. b의 b1
        //3. 공통부분 (a2)
        //4. [a1]*[a2] +[a2][b1]을 +=누적합
        for(int i=0; i<arr1.length; i++){
            //값을 꺼내온다.
            for(int i2=0;i2<arr2[0].length; i2++){
                for(int i3=0; i3<arr2.length; i3++){
                    //공통 부분
                 answer[i][i2]+= arr1[i][i3]*arr2[i3][i2];
                
                    
                }
                
            }
        }
        return answer;
    }
}