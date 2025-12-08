import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Scanner;
public class Main {
//원래는 for문을 돌려서 문제를 풀었지만, 시간초과가 나 누적합이라는 알고리즘을 힌트로얻어 문제를 풀었다

    //	public static int solution(int a, int[][] n, int[][] tmp) {
//		//int sum = 0;
//	//	System.out.println(n[a][0] + " " + n[a][1] + " " + n[a][2] + " " + n[a][3]);
//		for (int i = n[a][1]; i <=n[a][3]; i++) {
//			for (int i2 = n[a][0]; i2 <= n[a][2]; i2++) {
//			//	System.out.println(i+"/"+i2);
//			//	System.out.println("="+tmp[i2][i]);
//			//	System.out.println(tmp[i2][i] + " " + i2 + "/" + i);
//				//sum += tmp[i][i2];
//			//	System.out.println(i2);
//		}
//		}
//		int 
//		return sum;
//	}

	public static int solution(int a,int[][]x,int[][] s) {

		int des = 0;
		
			des=s[x[a][2]][x[a][3]]-(s[x[a][2]][x[a][1]-1]+s[x[a][0]-1][x[a][3]]);
			//더하는 이유: 예로 (1,1)부터 더한 부분이기 때문에 겹치는 부분이 두번 없어져서 1번만 없어지게끔 +해준다.
			des+=s[x[a][0]-1][x[a][1]-1];
		
		return des;
	}
   	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt(); // 합을 구해야하는 횟수 M
		int[][] tmp = new int[N+1][N+1];
		int[][] s= new int[N+1][N+1];
		// 배열 입력받기
		for (int i = 1; i <= N; i++) {
			for (int i2 =1; i2 <= N; i2++) {
				
				tmp[i][i2] = sc.nextInt();
				if(i==1 && i2==1) s[1][1]=tmp[1][1];
				else s[i][i2]=s[i-1][i2]+s[i][i2-1]+tmp[i][i2]-s[i-1][i2-1];
				//System.out.print(s[i][i2]+" ");
			}
			//System.out.println();
		}

		int[][] x = new int[M][4];
		
		for (int i = 0; i < M; i++) {
			x[i][0] = sc.nextInt();
			x[i][1] = sc.nextInt();
			x[i][2] = sc.nextInt();
			x[i][3] = sc.nextInt();
		}

		for (int i = 0; i < M; i++) {
			System.out.println(solution(i, x,s));
		}

	}
}