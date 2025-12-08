class Solution {
    	//바둑문제 풀때도 이방식을 사용해 풀었지만 접근방식을 생각해낼수 있지만,
	// 확인하는 방식을 보기전에 이 방식을 생각했을 때 범위 체크하는 걸 빼고 
	// 구현했었기 때문에 조금 더 알고리즘 공부를 해야겠다고 생각했습니다.
	//미로탐색 및 bfs/dfs 공부
    public int solution(String[][] board, int h, int w) {
		int answer=0;
		int n=board.length; 
	    //2.같은 색으로 색칠된 칸의 개수를 저장할 변수 count
	    int count=0;
	    //3. h와 w의 변화량을 저장할 정수 리스트 dh, dw를 만들고 각각 [0, 1, -1, 0], [1, 0, 0, -1]을 저장
	    int[] dh= {0,1,-1,0};
	    int[] dw={1,0,0,-1};
	    //4.반복문을 이용해 i값을 0~3까지 1씩 증가하면서 반복
	     for(int i=0; i<4; i++){
	         //4-1. 체크할 칸의 h, w 좌표를 나타내는 변수 h_check, w_check를 만들고 각각 h + dh[i], w + dw[i]를 저장
	         int x=h+dh[i];
	         int y=w+dw[i];
	         //4-2. h_check가 0 이상 n 미만이고 w_check가 0 이상 n 미만이라면 다음을 수행합니다.--> 범위를 꼭 체크해야함(까먹지않기)
	         if((x>=0&&x<n) &&(y>=0&&y<n)) {
	             // 4-2-a. board[h][w]와 board[h_check][w_check]의 값이 동일하다면 count의 값을 1 증가시킵니다.

	         if(board[x][y].equals(board[h][w])){
	             count++;
	         }
	         }
	     }
	    //count값을 answer에 담고 return
	    answer=count;

    return answer;

    }
}