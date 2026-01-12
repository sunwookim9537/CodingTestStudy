import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    static int cnt=0;
	static ArrayList<ArrayList<Integer>> num= new ArrayList<>();
	static void dfs(int[] visit,int v) {

		visit[v]=1;// 방문처리가 안되어있다면 재귀 돌기때문에 방문처리해주기 
		
		for(int n: num.get(v)) {// v와 연결된 모든 노트 탐색
			if(visit[n]!=1) {// ->방문처리가 되어있지 않다면 재귀로 파고들기 
				dfs(visit,n);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		/*dfs: 한길로 끝까지 들어갔다가, 막히면 돌아오는 탐색 (갈수있는 길, 더못가면 돌아옴)
		 * dfs 핵심 개념 (방문체크+ 재귀)
		 * 1) 방문 체크 
		 * 2)인접한 노드로 재귀 (방문 체크가 안되어있으면 연결되어있는 곳 다 가봄)
		 * 3) 재귀 =스택 
		 * 4) dfs 기본 틀

		 * void dfs(int v) {
   `			 visit[v] = 1;
			    for (int next : graph.get(v)) {
			        if (visit[next] == 0) {
			            dfs(next);
			        }
			    }
			}
			
		 ex) 연결요소 / 그래프 탐색/ 영역 개수/ 섬 개수/ 미로 / 백트래킹
		 
		 dfs- 깊이 우선/ 재귀 / 구현 쉬움 / 모든 경로 탐색
		 bfs- 너비 우선/ 큐 / 거리 계산에 유리 / 최단 거리 
		 * */
		int n=Integer.valueOf(st.nextToken());
		int m=Integer.valueOf(st.nextToken());
		
        //초기화 
		 for (int i = 0; i <= n; i++) {
	            num.add(new ArrayList<>());
	        }
        
		 //간선 연결
		for(int i=0; i<m; i++) {
			st= new StringTokenizer(br.readLine());
			int a=Integer.valueOf(st.nextToken());
			int b=Integer.valueOf(st.nextToken());
			num.get(a).add(b);
			num.get(b).add(a);
		}
		
		int[] visit= new int[n+1];
		
		for(int i=1; i<=n; i++) {
			if(visit[i]==0) {//방문 처리안된 곳
				dfs(visit,i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}