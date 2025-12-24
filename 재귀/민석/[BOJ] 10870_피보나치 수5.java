import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
public class Main{
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		
	
		
	    int N = Integer.parseInt(br.readLine());
		
		bw.write(String.valueOf(fibo(N)));

		bw.flush();
		bw.close();
		
	}
    static int fibo(int N) {
    	
    	if(N==0) {
    		return 0;
    	}
    	
    	if(N == 1) {
    		return 1;
    	}
    
    	return fibo(N-1) + fibo(N-2);
    	
    }
}