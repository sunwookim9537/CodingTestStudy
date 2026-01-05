import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void perm(int[] answer,int cnt, int start,int n, int m){
        	if(cnt==m) {
			for(int i=0;i<m;i++) {
				System.out.print(answer[i]+" ");
			}
			System.out.println();
			
			return;
		}
		for(int i=start; i<=n; i++) {//start:for문 어디서부터 시작할지 생각하기 
			 answer[cnt]=i;
			 
				perm(answer,cnt+1,i+1,n,m); //중복 처리를 위해 visited를 할까했는데 
				// nullpointer 나옴...구현하기도 빡세고 그래서 chatgpt에게 질문 -> 그냥 시작 위치만 있으면 된다.
				//i+1함으로써 이전값+1부터 시작하게끔 설정해둠
			}
    }
        
	public static void main(String[] args) throws IOException, NumberFormatException {
		// TODO Auto-generated method stub
		/*
		 * 자연수 n과 m이 주어졌을 때 조건을 만족하는 길이가 m인 수열을 모두 구함
		 * 1~n까지 자연수중에서 중복없이 m개를 고른 수열
		 * 고른 수열은 오름차순이여야한다.
		 * 
		 * 중복되는 수열을 여러번 출력하면 안됨
		 * 각 수열은 공백으로 구분해서 출력
		 * 수열은 사전 순으로 증가하는 순서로 출력
		 * 
		 * */
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n= Integer.valueOf(st.nextToken());
		int m= Integer.valueOf(st.nextToken());
		//System.out.println(n+"/"+m);
		// 1~n ->M개를 선택 (중복 x)
		
		int[] s=new int[m];
		
		perm(s,0,1,n,m);
	
    }
}