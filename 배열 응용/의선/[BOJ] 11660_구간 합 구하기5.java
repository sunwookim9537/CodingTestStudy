import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[][] arr = new long[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

      
        long[][] sumArr = new long[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1] + arr[i][j];
            }
        }

        for (int q = 0; q < m; q++) {
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();

            long sum = sumArr[e1][e2] - sumArr[s1-1][e2] - sumArr[e1][s2-1] + sumArr[s1-1][s2-1];
            System.out.println(sum);
        }

        sc.close();
    }
}
