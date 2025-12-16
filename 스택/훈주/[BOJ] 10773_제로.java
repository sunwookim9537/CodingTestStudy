import java.io.*;    // BufferedReader, InputStreamReader 사용
import java.util.*;  // Stack 사용

public class Main {
    public static void main(String[] args) throws Exception {
        // [입력 준비]
        // System.in(표준 입력)을 문자(텍스트)로 읽을 수 있게 감싸고,
        // BufferedReader가 "버퍼로 한 번에 많이 읽어서" 빠르게 처리하게 해줌
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // [첫 줄 K 읽기]
        // br.readLine()은 "한 줄 전체를 String으로" 읽음
        // Integer.parseInt로 숫자로 변환
        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        // [K번 반복]
        for (int i = 0; i < K; i++) {
            // 매 줄에 정수가 1개씩 → 한 줄 읽고 int로 변환
            int num = Integer.parseInt(br.readLine());

            // 0이면 최근 값 취소(pop), 아니면 기록(push)
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        // [스택에 남은 값 합산]
        int sum = 0;
        for (int v : stack) {
            sum += v;
        }

        // [출력]
        System.out.println(sum);
    }
}

/*
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();          // 입력 개수
        Stack<Integer> stack = new Stack<>();

        // K개의 정수 입력
        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();

            if (num == 0) {
                // 0이면 최근 값 삭제(pop)
                stack.pop();
            } else {
                // 0이 아니면 push
                stack.push(num);
            }
        }

        // 스택에 남은 숫자들의 합 계산
        int sum = 0;
        for (int value : stack) {
            sum += value;
        }

        System.out.println(sum);
    }
}
*/