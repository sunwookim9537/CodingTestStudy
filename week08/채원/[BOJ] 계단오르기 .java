import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

     
        int[] flr = new int[Math.max(n + 1, 3)];
        int[] answer = new int[Math.max(n + 1, 3)];

        for (int i = 1; i <= n; i++) {
            flr[i] = sc.nextInt();
        }

        
       answer[1] = flr[1];
       answer[2] = flr[1] + flr[2];
        

        // DP 반복문
        for (int i = 3; i <= n; i++) {
            // 점화식: (2칸 전에서 옴) vs (3칸 전 + 1칸 전 + 현재)
            answer[i] = Math.max(answer[i - 2] + flr[i], answer[i - 3] + flr[i - 1] + flr[i]);
        }

        System.out.println(answer[n]);
    }
}