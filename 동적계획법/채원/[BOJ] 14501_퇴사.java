import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N;

//	static public int dp(int day, int cnt) {
//		/* 문제를 풀다가 top-down(재귀)로 풀었는데 쉽게 안풀려서 챗지피티한테 질문함
//		 * 1) 상담을 한다면 dp[i] = P[i] + dp[i + T[i]]
//		 * 
//		 * 2) 상담을 안 한다면 dp[i] = dp[i + 1]
//		 * 
//		 * dp[i] = max(1, 2)
//		 */
//	
//
//	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// DP는 큰 문제를 작은 문제로 분해하고,
		// 그 결과를 저장(메모이제이션) 해서 중복 계산을 제거하는 알고리즘 기법
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());

		int[] day = new int[N + 2];
		int[] cost = new int[N + 2];
		int[] dp= new int[N+2];
		/*
		 * 언제 DP를 거꾸로 도는가?
			아래 조건 중 하나라도 해당되면 뒤에서부터다.
			dp[i]가 dp[i+1], dp[i+k]에 의존
			“i일부터 끝까지” 같은 정의
			일정 / 스케줄 / 퇴사 / 상담 문제
			
			DP는 “참조하는 값이 먼저 계산돼야 한다”
			이 문제는 미래를 참고하므로 역방향이 필수
		 * */
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			day[i] = a;
			cost[i] = b;

		}
		for(int i=N; i>=1; i--) {
			if(i+day[i]<=N+1) {
				//dp[i] = i번째 날부터 시작했을 때 얻을 수 있는 최대 이익
				//P[i] + dp[i + T[i]],  // 오늘 상담을 한다
				//dp[i + 1]             // 오늘 상담을 안 한다
				dp[i]= Math.max(dp[i+1], cost[i]+dp[i+day[i]]);
			}
            else {
				dp[i]=dp[i+1];
			}
		}
		System.out.println(dp[1]);

	}

}
