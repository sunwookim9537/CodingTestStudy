import java.util.*;
class Main{
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int start = 0;
        int end = 0;
        int total = 0;
        int cnt = 0;

        while(end <= n){
            if(total == n){
                cnt++;
                end++;
                total +=end;

            }else if(total<n){
                end++;
                total +=end;
            }else if(total>n){
                total -=start;
                start++;
            }
        }
        System.out.println(cnt);







    }
}