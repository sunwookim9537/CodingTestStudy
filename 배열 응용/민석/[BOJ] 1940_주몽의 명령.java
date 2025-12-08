import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		
	
		
		int N = Integer.parseInt(br.readLine());
	
		int M = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i =0 ; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start =0;
		int end = N-1;
		int answer = 0;
		Arrays.sort(arr);
		
		while(start<end) {
			
			int sum = arr[start]+arr[end];
			
			if(sum == M) {
				answer ++;
				end --;
				start++;
				
			}
			else if(sum > M) {
				end--;
			}
			else if(sum < M) {
				
				start++;
				
			}
		}
		bw.write(String.valueOf(answer));
		
		
	
		
		
		
		
	
		
		
	
		
		bw.flush();
		bw.close();
	}
}