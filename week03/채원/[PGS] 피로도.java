class Solution {
    public int dfs(int n, int[][] dungeons,int[] visited,int remain){
        int max=n;
        for(int i=0; i<dungeons.length;i++){
            if(remain>=dungeons[i][0] && visited[i]==0) {
                visited[i]=1;
                max = Math.max(
                    max,
                    dfs(n + 1, dungeons, visited, remain - dungeons[i][1])
                );
                visited[i]=0;
            }
        }
        return max;
    }
    public int solution(int k, int[][] dungeons) {
        /*
        피로도 -> 일정 피로도를 사용해 탐험
        유저가 탐험할 수 있는 최대 던전 수 return 
        
        1<=k<=5000( 현재 유저의 남은 피로도=k)
        1<=던전의 세로 행 길이<=8
        던전의 가로 행 길이 =2
        최소 필요 피로도>=소모 피로도
        서로 다른 던전의 최소 필요 피로도/소모 피로도가 서로 같을 수 있다.
        */
        int[] visited= new int[dungeons.length];
        int answer= dfs(0,dungeons,visited,k);
        return answer;
    }
}