package studycodingtest.PermutationAndCombination;

import java.util.Scanner;

/*
    1~N 까지의 숫자 중에서 M개를 중복없이 선택하여 조합을 생성
    재귀 호출 시 다음 선택은 현재 선택은 다음 선택한 수보다 i+1부터 진행(오름차순)
    순서를 유지하고 종복되는 조합이 오지 않도록
    결국 조합을 DFS로 생성하는것


 */
public class BOJ_NAndM {
    private static int N,M;
    private static int[] combination;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        // 조합을 저장할 배열 초기화
        combination=new int[M];
        sc.close();

        // 시작과 끝 1~설정 아직 안함
        dfs(1, 0);
        System.out.print(sb.toString());
    }
    private static void dfs(int start,int deqth){
        // 종료 조건
        if(deqth==M){
            for(int num:combination){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        // DFS 탐색 하면서 내려가고 start 부터 시작하니까 오름차순유지
        for(int i =  start; i<=N; i++){
            // 현재 깊이
            combination[deqth]=i;
            // 중복 방지
            dfs(i+1,deqth+1);
            combination[deqth]=0;
        }
    }

}
