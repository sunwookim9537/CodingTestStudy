import java.util.*;
class Solution {
    /*
    최단 거리를 위한 bfs 사용
     visited, Queue(FIFO) 사용
      boolean [][] visited = new boolean[w][h];
      Queue<int[]> q = new LinkedList<>();
       q.offer(new int[]{0,0,1}); // 시작 좌표 이동할 거리 1
       visited[0][0] = true;

    방향 배열
     int[] dx = {1, -1, 0, 0};
     int[] dy = {0, 0, 1, -1};
    */
    
    public static int bfs(int[][] maps,Queue<int[]> q, int n, int m, boolean[][] visited){
        
        //q,0,0,n,m
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while(!q.isEmpty()){
            
            int[] cur= q.poll();
            int x= cur[0];
            int y= cur[1];
            //int c= cur[2]; -->c를 재사용하면서 다음 방향에도 누적
            // 0~N-1 이고 M-1임 
            if(x==n-1 && y==m-1) return cur[2];
          for(int i=0; i<4; i++){
           
            x= cur[0]+dx[i];
            y= cur[1]+dy[i];
            
             if((x>=0 &&x<n)&&(y>=0 &&y<m)){
                if(maps[x][y]!=0){    
                 if(!visited[x][y]){
                     visited[x][y]=true;
                     //c+=1;
                     q.offer(new int[]{x,y,cur[2]+1});
                 }
             }
          }
          }
          
        }
         return -1;
        
    }
    public int solution(int[][] maps) {
        /*게임 맵의 상태 : maps가 매개변수 -> 지나가야하는 칸의 개수의 최소값
       
        1. 상대 팀 진영에 도착할 수 없을 땐 -> -1 리턴
        
        2. map은 0,1로 이루어져 있을 때 
            - 0: 벽이 있는 자리
            - 1: 벽이 없는 자리
        3. 위치 설정
            - 처음 캐릭터 위치 (1,1)
            - 상대방 위치 (n,m)
            n,m이 주어지지 않는다. -> 주어져 있는 maps에서 길이 측정하기 
        4. 최단거리 -> 가중치 없으면 bfs
        
        */
        int answer = 0;
        int n= maps.length;
        int m= maps[0].length;
        
        Queue< int[]> q= new LinkedList<>();
        boolean[][] visited= new boolean[n][m];
       //2차원 배열에서는 안됨 : Arrays.fill(visited,false);
        for (int i = 0; i < n; i++) {
        Arrays.fill(visited[i], false);
        }
        // 내 위치 먼저 넣어주기 
        q.offer(new int[]{0,0,1});
        answer=bfs(maps,q,n,m,visited);
        
        return answer;
    }
}