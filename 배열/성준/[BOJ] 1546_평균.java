package StudyCodingTest.Arr;
/*
    점수 중 최대값 max() 구하기 = M
    나머지 점수로 점수/M*100 => 이럴거면 Arrays.sort() 사용
    출력 결과 전부다 doubel 형태 쓰고 avg double 형태로 받아.
    
*/

import java.util.Arrays;
import java.util.Scanner;
public class BOJ_Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 과목 수 받기 & 점수배열 생성
        int N = sc.nextInt();
        double[] score = new double[N];

        // 값 넣어주기
        for (int i = 0; i < N; i++) {
            score[i] = sc.nextDouble();
        }

        // 정렬
        Arrays.sort(score);
        double max = score[N-1];

        // 계산
        double sum = 0;
        for(int i = 0; i<N; i++){
            sum+=(score[i]/max)*100;
        }
        double avg = sum/N;
        System.out.println(avg);
    }
}

