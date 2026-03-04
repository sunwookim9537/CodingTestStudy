//오름차순 : o1 - o2
// 내림차순 : o2 - o1
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Student> listStudent = new ArrayList<>();
        int iCntStudent = Integer.parseInt(st.nextToken());

        for(int i = 0; i < iCntStudent; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            listStudent.add(new Student(name, kor, eng, math));
        }

        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.kor == o2.kor) {
                    if(o1.eng == o2.eng) {
                        if(o1.math == o2.math) {
                            return o1.name.compareTo(o2.name);
                        }
                        return o2.math - o1.math;
                    }
                    return o1.eng - o2.eng;
                }
                return o2.kor - o1.kor;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Student student : listStudent) {
            sb.append(student.name).append('\n');
        }

        System.out.println(sb);
    }

    static class Student {
        String name;
        int kor, eng, math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }

}