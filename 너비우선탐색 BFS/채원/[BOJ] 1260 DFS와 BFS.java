import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void dfs(ArrayList<ArrayList<Integer>> p,int start, boolean[] visit) {
		visit[start]=true;
		System.out.print(start+" ");
		for(int i :p.get(start)) {
			if(!visit[i]) {
				dfs(p,i,visit);
			}
		}
	}
	
	public static void bfs(ArrayList<ArrayList<Integer>> p, int start, boolean[] visit) {
		Queue<Integer> q= new LinkedList<>();
		visit[start]=true;
		q.offer(start);
		while(!q.isEmpty()) {
			int c= q.poll();
			System.out.print(c+" "); // poll하고 해당 값 출력 
			for(int i: p.get(c) ) {
				if(!visit[i]) {
					visit[i]=true;
					q.offer(i);
				}
					
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//DFS로 탐색한 결과
		//BFS로 탐색한 결과 
		// 단 방문할 수 있는 정점이 여러개인 경우에는 정점 번호가 작은걸 먼저 방문
		// 더이상 방문할 수 있는 점이 없는 경우 종료 
		//1~N
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		ArrayList<ArrayList<Integer>> num= new ArrayList<>();
		int n= Integer.valueOf(st.nextToken());
		int m= Integer.valueOf(st.nextToken());
		int v= Integer.valueOf(st.nextToken()); //탐색을 시작할 정점의 번호 v
		
		//방문 체크 = 정점 개수 기준 (n+1)
		boolean[] visit= new boolean[n+1];//bfs에 사용
		boolean[] visit2= new boolean[n+1]; // dfs에 사용
		
		for(int i=0; i<=n; i++){
			num.add(new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) {
			st= new StringTokenizer(br.readLine());
			int a= Integer.valueOf(st.nextToken());
			int b= Integer.valueOf(st.nextToken());
			num.get(a).add(b);
			num.get(b).add(a);
//			map[a]=b;
//			map[b]=a;
			
		}
		//정렬 필수 !!!!// 단 방문할 수 있는 정점이 여러개인 경우에는 정점 번호가 작은걸 먼저 방문
		//이중 ArrayList 정렬하는 방법을 배웠다...
		for(int i=0; i<=n; i++) {
			num.get(i).sort(null);//리스트를 기본 정렬 기준(오른차순으로 정렬)
			//null==comparator를 직접 주지 않겠다는 뜻
			/*자바 8부터 제공되는 메서드
			 * Comparator를 넘기면 그 기준으로 정렬
			 * null을 넘기면 “자연 정렬” 사용
			 * */
		}
		
		Arrays.fill(visit2, false);
		Arrays.fill(visit, false);
		//dfs
		dfs(num, v, visit2);
		System.out.println();
		//bfs
		bfs(num,v,visit);
	}
}