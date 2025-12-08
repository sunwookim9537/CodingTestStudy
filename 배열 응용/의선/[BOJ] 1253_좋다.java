import java.util.*;
class Main{
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int cnt = 0;

        for(int i = 0; i < n; i++){
            int num = arr[i];
            int start = 0;
            int end = n-1;

            while(start < end){
                int sum = arr[start] + arr[end];
                if(num == sum){
                    if(start!=i&&end!=i){
                        cnt++;
                        break;
                    }else if(start==i){
                        start++;
                    }else if(end==i){
                        end--;
                    }

                }else if(num<sum){
                    end--;
                }else if(num>sum){
                    start++;
                }
            }


        }


        System.out.println(cnt);


    }
}