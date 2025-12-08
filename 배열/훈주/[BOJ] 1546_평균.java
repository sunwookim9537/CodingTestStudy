import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. 과목 개수 입력
        int N = sc.nextInt();

        // 2. 점수 배열 생성
        int[] scores = new int[N];

        // 3. 점수 입력 후 배열 저장
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }

        // 4. 최고점 M 찾기
        int M = scores[0];
        for (int i = 1; i < N; i++) {
            if (scores[i] > M) {
                M = scores[i];
            }
        }

        // 5. 점수 조작 후 합 계산
        double sum = 0.0;
        for (int i = 0; i < N; i++) {
            double newScore = (double) scores[i] / M * 100;
            sum += newScore;
        }

        // 6. 평균 계산
        double average = sum / N;

        // 7. 출력 (오차 허용 → double 그대로 OK)
        System.out.println(average);
    }
}