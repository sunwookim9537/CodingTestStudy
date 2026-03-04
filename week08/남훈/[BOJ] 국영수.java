import java.util.*;

public class Main {
    // Student 객체끼리 비교하는 기준 만들어서 정렬 가능하도록
    static class Student implements Comparable<Student> {
        String name;
        int korean;
        int english;
        int math;

        Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student other) {
            // 1. 국어 점수 내림차순
            if (this.korean != other.korean) {
                return other.korean - this.korean;
            }
            // 2. 영어 점수 오름차순
            if (this.english != other.english) {
                return this.english - other.english;
            }
            // 3. 수학 점수 내림차순
            if (this.math != other.math) {
                return other.math - this.math;
            }
            // 4. 이름 사전순 오름차순
            return this.name.compareTo(other.name);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 학생 수 입력
        ArrayList<Student> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int korean = sc.nextInt();
            int english = sc.nextInt();
            int math = sc.nextInt();
            // Student 객체 생성 후 리스트에 추가
            list.add(new Student(name, korean, english, math));
        }
        Collections.sort(list);   // 정렬
        // 정렬된 순서대로 학생 이름만 출력
        for (Student s : list) {
            System.out.println(s.name);
        }
        sc.close();
    }
}