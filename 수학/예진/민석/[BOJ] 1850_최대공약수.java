import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //첫째 줄에 두 자연수 A와 B를 이루는 1의 개수가 주어진다. 입력되는 수는 2의 63승 보다 작은 자연수이다.
        //long을 쓰자.
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long gongyak = gongyaksoo(A,B);
        StringBuilder sb = new StringBuilder();
        
        //기존에 String str ="" 해놓고 1씩 붙이려함..
        for(long i =0L;i<gongyak;i++){
            sb.append("1");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();





    }

    static long gongyaksoo(long a, long b) {

        while(b != 0 ){

            long remain = a % b;

            a = b;
            b = remain;


        }
        return a;



    }
}