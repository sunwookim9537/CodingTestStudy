package studycodingtest.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
    연결 요소 : 어떤 정점에서 시작했을 때 간선을 따라 이동 가능한 정점들의 최대 집합
    인접 리스트 사용하고
    n : 노드 개수 m : 간선 개수
    인접 리스트 사용
    for (n 개수 반복)
        인접 체크
     for (m 개수 만큼 체크)
        인접리스트 데이터 저장
      for
        if 방문하지 않은 노드
         연결 노드 ++
       DFS

       연결 노드의 개수 출력하기
       재귀로 풀어야 하고
 */
public class BOJ_Findthenumberofconnectedcomponents {

    // 인접 리스트에 그래프 저장
    static ArrayList<Integer>[] graph;

    // 방문 기록을 저장
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정점 개수 N, 간선 개수 M
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        // 배열에 하나씩 담아
        graph = new ArrayList[N+1]; // 1부터 시작하니까
        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<Integer>();
        }
        // 방문 배열 초기화
        visited = new boolean[N + 1];
        
        // 간선 입력
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int Start = Integer.parseInt(st.nextToken()); // 시작점
            int end = Integer.parseInt(st.nextToken()); // 끝점
            // 양뱡향으로 갈 수 있으니까
            graph[Start].add(end);
            graph[end].add(Start);
        }
        // 연결 요소 개수 세기
        int cnt = 0;
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                cnt++;
                DFS(i);
            }
        }
        System.out.println(cnt);
    }

    private static void DFS(int i) {
        // 방문 노드이면 탐색 종료
        if(visited[i]){
            return;
        }
        visited[i] = true;
        // 현재 연결된 노드 찾고
        for(int j : graph[i]){
            // 방문 안된거면
            if(!visited[j]){
                DFS(j);
            }
        }
    }
}
