class Solution {

    private boolean[] visited;
    private int max = 0;

    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);

        return max;
    }

    private void dfs(int fatigue, int[][] dungeons, int count) {

        // 현재까지 탐험한 던전 수 갱신
        max = Math.max(max, count);

        for (int i = 0; i < dungeons.length; i++) {

            // 아직 방문 안했고, 입장 가능하면
            if (!visited[i] && fatigue >= dungeons[i][0]) {

                visited[i] = true;

                dfs(fatigue - dungeons[i][1], dungeons, count + 1);

                visited[i] = false; // 백트래킹
            }
        }
    }
}