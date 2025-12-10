package StudyCodingTest.AplicationOfArrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    수가 10억인데? long
     투포인터 알고리즘
     1,2 는 일단 good 이 아닌데?
     for(반복해서 저장)
     일단 Arrays.sort();
     for(수가 맞는지 체크)
      A[i] + A[j] > M : j--
      A[i] + A[j] < M : i++
      A[i] + A[j] == M : count ++
 */
public class BOJ_Good {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 배열 저장하고
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);

        int count = 0;

        // 수를 보고 판별
        for (int k = 0; k < N; k++) {
            long M = A[k];

            int i = 0; // MIN
            int j = N - 1; //MAX


            while (i < j) {
                if (i == k) {
                    i++;
                    continue;
                }
                if (j == k) {
                    j--;
                    continue;
                }
                //위 if 문 때문에 범위 벗어난거 제어
                if (i>=j){
                    break;
                }
                long sum = A[i] + A[j];

                //투포인터
                if (sum > M) {
                    j--;
                } else if (sum < M) {
                    i++;
                } else {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
