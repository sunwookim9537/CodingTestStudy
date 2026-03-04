import java.util.*;
class Solution {
    
   
    public int[] solution(String[] maps) {
        /*
            1.격자의 각 칸에는 'x' 또는 1~9 사이의 자연수
                x= 바다 , 숫자= 무인도 
                -> 상 하 좌 우로 연결되는 땅은 하나의 무인도를 이룬다.
            2.지도의 각 칸에 적힌 숫자는 식량을 나타냄
                -> 상 하 좌 우 로 연결되는 칸에 적힌 숫자를 모두 합한 값은 해당 무인도에서 최대 며칠동안 머물 수 있는지 나타냄
            3.각 섬에서 최대 며칠 씩 머물수 있는지 알아본 뒤 놀러갈 섬을 결정
            
            지도를 나타내는 문자열 배열 maps가 매개변수로 주어질 때 각 섬에서 최대 며칠씩 머무를 수 있는지 "오름차순"으로 담아 return 
        */
       // int[] answer = {};
        int[][]visited= new int[maps.length][maps[0].length()];
        String[][] map= new String[maps.length][maps[0].length()];
        // 맵 전체 탐색
        StringBuilder sb= new StringBuilder();
        
            for(int i=0; i<maps.length;i++){
            for(int i2=0; i2<maps[i].length(); i2++){
                map[i][i2]=String.valueOf(maps[i].charAt(i2));
            }
            }
        for(int i=0; i<maps.length;i++){
            for(int i2=0; i2<maps[i].length(); i2++){
                if(! "X".equals(map[i][i2])&&visited[i][i2]==0) {
                    
                    visited[i][i2]=1;
                    int tmp=dfs(i,i2,visited,map);
                    System.out.println(tmp);
                    sb.append(tmp);
                    sb.append("/");
                }
            }
         
        }
         if(sb.length()==0) return new int[]{-1};  
        String[] a= sb.toString().split("/");
          
         int[] answer= Arrays.stream(a).mapToInt(Integer::parseInt).toArray();
       // if(answer.isEmpty()) return new int[]{-1};
        Arrays.sort(answer);
       return answer;
    }
    
    int dfs(int x, int y,int[][] visited, String [][] map){
        int sum=Integer.parseInt(map[x][y]) ;// 현재값 기준으로 누적값을 구해야함
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        
        for(int i=0; i<dx.length; i++){
            int px= x+dx[i];
            int py= y+dy[i];
            if(px<0 || py<0 || px>=map.length || py>=map[0].length){
                //범위 체크
                continue;
            }
            //방문여부 확인 
            if(visited[px][py]==1) continue;
            if("X".equals(map[px][py])) continue;
            
                visited[px][py]=1;
                sum+=dfs(px,py,visited,map);
            
        }
        return sum;
    }
}