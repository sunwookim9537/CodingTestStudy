package studycodingtest.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    FIFO
    위에 하나 버리고 다음 카드 밑으로 내리고 반복 해서 남은거 찾기
    N개 카드
    for(카드 개수 반복)
        카드 저장
    while(카드>1)
        맨 위 카드 버리고 poll
        맨 위 카드 밑으로 내려 poll -> add
 */
public class BOJ_Car2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        int N = sc.nextInt();

        // 차례로 담아
        for(int i = 1; i<N+1; i++){
            queue.add(i);
        }
        // 반복
        while(queue.size() > 1){
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
