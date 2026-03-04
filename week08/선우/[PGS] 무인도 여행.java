import java.util.*;

class Solution {

    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int n, m;

    public int[] solution(String[] maps) {

        n = maps.length;
        m = maps[0].length();

        visited = new boolean[n][m];

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(!visited[i][j] && maps[i].charAt(j) != 'X'){
                    int sum = dfs(i,j,maps);
                    list.add(sum);
                }

            }
        }

        if(list.size() == 0){
            return new int[]{-1};
        }

        Collections.sort(list);

        int[] answer = new int[list.size()];

        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    static int dfs(int x, int y, String[] maps){

        visited[x][y] = true;

        int sum = maps[x].charAt(y) - '0';

        for(int d=0; d<4; d++){

            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx>=0 && ny>=0 && nx<n && ny<m
                && !visited[nx][ny]
                && maps[nx].charAt(ny) != 'X'){

                sum += dfs(nx,ny,maps);
            }
        }

        return sum;
    }
}