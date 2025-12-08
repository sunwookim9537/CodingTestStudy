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
		
		
		int N = Integer.parseInt(br.readLine());

		int arr[]= new int[N+1];
		for(int i = 1 ;i<N+1;i++) { //배열초기화
			arr[i]=i;
		}
		
		int pointer1 = 1;
		int pointer2 = 1;
		int answer = 0;
		int sum = 0;
		
		for(int i =1;i<=N;i++) {
			
			while(sum < N && pointer2 <= N) {
				
				sum += arr[pointer2];
				pointer2++;
			}
			if (sum == N) {
				  answer++;
			}
			sum -= arr[pointer1];
			pointer1++;
		      
		}
		
		bw.write(String.valueOf(answer)+"\n");
		bw.flush();
		bw.close();
	}
}