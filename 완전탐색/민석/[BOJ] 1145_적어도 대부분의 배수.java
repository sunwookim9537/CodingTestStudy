import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int arr[]= new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<5;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        int index = 1;
        while(true){

            int cnt = 0; //맞는거 카운트용

            for(int a : arr){

                if(index % a ==0){
                    cnt++;
                }

            }
            if(cnt>=3){
                bw.write(String.valueOf(index));
                bw.flush();
                bw.close();
                return;
            }
            index++;

        }



    }
}