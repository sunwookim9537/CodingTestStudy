package StudyCodingTest.AplicationOfArrays;

import java.util.Scanner;

/*
 	1줄 개수 N , 합 횟수 M
 	2줄 N개의 수
 	3줄~M  구간 i~j => 합계[j] - 합계[i-1]

 	int N으로 줄 개수 받고 int M으로 합할 햇수 고르고
 	N_num 해서 값을 받고 .split(" ")이거로 하나씩 값 해주고
 	for문으로  i~j까지로 ++ 하면 되는거 같은데.

    하하하하하 너 진짜 죽어.....시간초과 달달하네
    무지성 제출해서 통과를 해서 시간 복잡도는 잘 모릅니다

 	누적합 알고리즘(prefix sum)이 존재
 	 prefix[j] - prefix[i-1] 뒤 
 */
public class BOJ_RangeSum4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 배열 크기
        int M = sc.nextInt(); // 몇번 반복할지

        // 누적합 저장 배열, N+1은 index가 1부터 시작을 함
        int[] prefix = new int[N+1];

        // 배열 입력 + prefix 생성( 여기서 하나씩 전부 더 해줘)
        for (int i = 1; i<N+1; i++) {
            prefix[i] = prefix[i - 1] + sc.nextInt();
        }
        StringBuilder sb = new StringBuilder();

        // M 개의 구간 합 출력
        for(int k = 0; k<M; k++){
            int i = sc.nextInt();
            int j = sc.nextInt();

            // 이게 누적합의 공식 : prefix[j] - prefix[i-1] => 시간 복잡도 O(1)
            // prefix(다 더했던 곳) - 구간의합
            sb.append(prefix[j] - prefix[i-1]).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
}