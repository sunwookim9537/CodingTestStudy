import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long arr[]= new long[N];
        for(int i = 0 ;i<N;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        int answer = 0;
        Arrays.sort(arr);

        for(int i = 0 ; i<N;i++){

            int left = 0;
            int right = N-1;


            while(left < right){

                long sum = arr[left] + arr[right];
                if(sum == arr[i]){

                    if(left != i && right != i){
                        answer++;
                        break;
                    }
                    else if(left ==i){
                        left++;

                    }
                    else if(right ==i){
                        right--;
                    }
                }
                else if(sum < arr[i]){//더한값이 목표값보다 작으면
                    left++;
                }
                else if(sum > arr[i]){//더한값이 목표값보다 크면
                    right--;
                }

            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();


    }
}