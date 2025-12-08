import java.util.*;
class Main{
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int cnt=0;
        int start = 0;
        int end = arr.length-1;

        while(start != end){
            int sum = arr[start] + arr[end];
            if(sum == m){
                cnt++;
                end--;
            }else if(sum > m){
                end--;
            }else if(sum < m){
                start++;
            }
        }
        System.out.println(cnt);










    }
}