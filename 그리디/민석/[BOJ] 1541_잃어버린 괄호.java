import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split("-");
        int result = 0;

        for (int i = 0; i < arr.length; i++) {

            
 
            int sum = 0;
            String[] arr2 = arr[i].split("\\+");

            for (int j = 0; j < arr2.length; j++) {
                sum += Integer.parseInt(arr2[j]);
            }

            if (i == 0) {
                result += sum;
            }
            else {
                result -= sum;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
