package studycodingtest.Recursion;

import java.util.Scanner;
/*
    이거 N! => 1~N까지 전부 곱해야해
    그냥 반복문 돌리며 나오는데??
    자기 자신을 쓰기만 하면 그냥 재귀알고리즘인가?
 */
public class BOJ_Factorial2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();

        long result = 1;
        for(int i=1; i<N+1; i++){
            result *= i;
        }
        System.out.println(result);
    }
}
