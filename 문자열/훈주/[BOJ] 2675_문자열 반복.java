public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();   // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {

            int R = sc.nextInt();   // 반복 횟수
            String S = sc.next();   // 원본 문자열

            String result = "";     // 새 문자열(P)을 저장할 공간

            // 문자열의 각 문자에 대해 반복
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);   // i번째 문자 꺼내기

                // 문자를 R번 반복해서 result에 더하기
                for (int j = 0; j < R; j++) {
                    result = result + c;
                }
            }

            System.out.println(result);
        }
    }
}