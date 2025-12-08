 
import java.util.Arrays;
import java.util.Scanner;

/* 1940 주몽 실버4 */
public class Main {

    public static void main(String[] args) {
        int count = 0;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();  // 공백 제거
        
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        // 정렬
        Arrays.sort(arr); 

        int start = 0; 
        int end = N - 1;
        while(start < end){
            int sum = arr[start] + arr[end];
            if(sum == M) { 
                count++;
                start++;
                end--; 
            }
            else if(sum < M) start++;
            else end--;
        }
        
        System.out.println(count);

        sc.close();
    }

}