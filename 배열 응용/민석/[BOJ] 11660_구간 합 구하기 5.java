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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[N][N];
		int sum[][] = new int [arr.length + 1][arr[0].length + 1]; //합을 구하느 배열
		
		
		for(int i =0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j =0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1 ;i <= N;i++) {
			
			for(int j = 1 ;j<= N;j++) {
				
				sum[i][j] = sum[i-1][j] + sum[i][j-1]  - sum[i-1][j-1] + arr[i-1][j-1]; //전체합 구하기 
			}
		}
		
		
		
		for ( int i = 0 ;i<M;i++) {
			
			st=new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int answer = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1] ;
			
			bw.write(String.valueOf(answer)+"\n");
			
			
		}
	
	
		
		bw.flush();
		bw.close();
	}
}