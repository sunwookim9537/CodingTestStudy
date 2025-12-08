import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.*;
public class Main {
//구간합인줄 모르고 이중for문했다가 시간초과났었다가 누적합으로 풀었습니다.
    public static int solution(int a, int b,int[] n) {
	return n[b]-n[a-1];
	}
    public static void main(String[] args) throws Exception {
  Scanner sc= new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int a;
		int b;
		int[] numN= new int[N];
		int [] sum= new int[N+1];
		sum[0]=0; //0까지의 합은 0으로 해둠
		for(int i=0; i<N; i++) {
			numN[i]=sc.nextInt();
			if(i==0){ sum[i+1]=numN[i];}
			else sum[i+1]=sum[i]+numN[i];
			//System.out.println(sum[i]+"~");
		}
		int[][] tmp=new int[M][2];
		for(int i2=0; i2<M; i2++) {
			
			tmp[i2][0]=sc.nextInt();
			tmp[i2][1]=sc.nextInt();
			
		}
		for(int i3=0; i3<M; i3++) {
            //백준은 ln사용해야함
			System.out.println(solution(tmp[i3][0],tmp[i3][1],sum));
		}

  }
}