import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main { // 클래스 이름만 math에서 Main으로 변경했습니다.
    static class score{
        String name;
        int leng;
        int eng;
        int math;
        score(String name, int leng, int eng,int math) {
           this.name= name;
            this.leng = leng;
            this.eng= eng;
            this.math=math;
        }
    }
     public static void main(String[] args) throws IOException {

         BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st= new StringTokenizer(br.readLine());

         int testCase= Integer.parseInt(st.nextToken());
         List<score> student= new ArrayList<>();

         for(int i=0; i<testCase; i++){
             StringTokenizer st1= new StringTokenizer(br.readLine());
             String name= st1.nextToken();
             int tmpLeng= Integer.parseInt(st1.nextToken());
             int tmpEng= Integer.parseInt(st1.nextToken());
             int tmpMath= Integer.parseInt(st1.nextToken());

           student.add(new score(name,tmpLeng,tmpEng,tmpMath));
         }

         student.sort((score a, score b)->{
             if(a.leng==b.leng){
                 if(b.eng==a.eng){
                     //같으면 수함 점수가 감소
                     if(a.math==b.math){
                         return (a.name).compareTo(b.name);
                     }
                     else return b.math-a.math;
                 }
                 else return a.eng-b.eng;
             }
             else return b.leng-a.leng;
         });
         StringBuilder sb= new StringBuilder();
         for(score s : student){
             sb.append(s.name).append("\n");
         }
         System.out.println(sb);
    }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { // 1. 클래스명을 반드시 Main으로 변경
    static class Score { // 클래스 첫 글자는 대문자가 관례입니다.
        String name;
        int kor, eng, math;

        Score(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N의 값이 클 수 있으므로 예외 처리를 고려한 입력 받기
        int n = Integer.parseInt(br.readLine().trim());
        List<Score> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students.add(new Score(name, kor, eng, math));
        }

        // 정렬 로직: 중첩 if 대신 가독성 좋은 'Early Return' 방식
        students.sort((a, b) -> {
            if (a.kor != b.kor) return b.kor - a.kor;   // 국어 내림차순
            if (a.eng != b.eng) return a.eng - b.eng;   // 영어 오름차순
            if (a.math != b.math) return b.math - a.math; // 수학 내림차순
            return a.name.compareTo(b.name);           // 이름 오름차순
        });

        // 출력 최적화
        StringBuilder sb = new StringBuilder();
        for (Score s : students) {
            sb.append(s.name).append("\n");
        }
        System.out.print(sb);
    }
}
*/

/*
list.stream()
    .sorted(Comparator.comparing(Student::getKor, Comparator.reverseOrder()) // 국어 내림
        .thenComparing(Student::getEng)                                     // 영어 오름
        .thenComparing(Student::getMath, Comparator.reverseOrder())        // 수학 내림
        .thenComparing(Student::getName))                                  // 이름 오름
    .forEach(s -> System.out.println(s.getName()));
*/