import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. 입력 도구 준비
        Scanner sc = new Scanner(System.in);

        // 2. 첫 번째 줄: 숫자의 개수 N 입력
        int N = sc.nextInt();

        // 3. 두 번째 줄: 숫자들이 붙어 있는 문자열 입력
        String s = sc.next();   // 예: "54321"

        // 4. 합계를 저장할 변수
        int sum = 0;

        // 5. 문자열의 각 문자를 하나씩 꺼내서 숫자로 바꾸고 더하기
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);   // i번째 문자 ('0' ~ '9')
            int digit = c - '0';    // 문자 → 정수 (예: '5' - '0' = 5)
            sum = sum + digit;      // sum에 더하기
        }

        // 6. 결과 출력
        System.out.println(sum);

        sc.close();
    }
}