package studycodingtest.Recursion;

import java.util.Scanner;

/*
    n이 0과 1이면 바로 나오게 해야해.
    그후부터 F(n) = F(n-1)+F(n-2)
    temp 에 저장해서 앞뒤 값 해서 돌리면 될듯 그리고 값 교환 해주고

 */
public class BOJ_FibonacciNumbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        if(n==0){
            System.out.println(0);
            return;
        }
        if(n==1){
            System.out.println(1);
            return;
        }
        int prev = 0; // F(0)
        int curr = 1; // F(1)

        for(int i=2; i<n+1; i++){
            int temp = curr+prev;
            prev = curr;
            curr = temp;
        }
        System.out.println(curr);
    }
}
