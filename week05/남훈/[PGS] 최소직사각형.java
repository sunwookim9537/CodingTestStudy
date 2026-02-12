class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int height = 0;

        for (int i = 0; i < sizes.length; i++) {
            // 현재 명함의 두 변
            int w = sizes[i][0];
            int h = sizes[i][1];

            // 큰 값은 가로, 작은 값은 세로로 통일
            int width = Math.max(w, h);
            int height = Math.min(w, h);

            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxWidth * maxHeight;
    }
}