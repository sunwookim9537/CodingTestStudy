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

        /*
        째 줄에 N(1 ≤ N ≤ 5,000,000)과 K (1 ≤ K ≤ N)이 주어진다.

        둘째에는 A1, A2, ..., AN이 주어진다. (-109 ≤ Ai ≤ 109)

		정렬 딸~깍~!
         */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i<N;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        bw.write(String.valueOf(arr[K-1]));







        bw.flush();
        bw.close();
    }
}