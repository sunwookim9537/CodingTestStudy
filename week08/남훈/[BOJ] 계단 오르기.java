import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 계단 개수

        //인덱스를 1번부터 쓰기 위해서 n+1로
        int[] score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 계단에 점수 입력
            score[i] = sc.nextInt();
        }

        // 계단이 1개일 때
        if (n == 1) {
            System.out.println(score[1]);
            return;
        }

        // 계단이 2개일 때
        if (n == 2) {
            System.out.println(score[1] + score[2]);
            return;
        }

        int[] dp = new int[n + 1];
        dp[1] = score[1];
        dp[2] = score[1] + score[2];
        dp[3] = Math.max(score[1] + score[3], score[2] + score[3]);

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
        }
        System.out.println(dp[n]);
        sc.close();
    }
}