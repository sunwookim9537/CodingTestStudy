import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        /*
         * set에 저장 후 size == relation.length와 비교해서 중복 확인
         * 중복이 없는 컬럼과 중복이 있는 컬럼을 구분 -> 학번 | 이름, 전공, 학년
         * 중복이 없는 컬럼은 그 자체로 primary key -> 개수 카운트 -> 학번 (1개)
         * 중복이 있는 컬럼끼리 조합 -> 이름, 전공, 학년
         * - 중복이 있는 컬럼끼리 조합 후 set에 저장하여 size로 후보키 검사
         * - 2개, 3개, 4개의 컬럼 순차대로 조합하여 검사
         * - (이름, 전공) (이름, 학년) (전공, 학년) 조합 검사 -> (이름, 전공)이 가능
         * - (이름, 전공)을 제외한 나머지 컬럼끼리 조합하여 3개의 컬럼 조합 검사
         * 
         * 코드
         * String[][] 을 순회하면서 컬럼별로 set에 저장 후,
         * 중복이 있는 컬럼의 인덱스와 중복이 없는 컬럼의 인덱스 각각 저장
         */

        // 컬럼 개수
        int column = relation[0].length;

        // 중복 없는 컬럼 인덱스 리스트
        List<Integer> unique = new ArrayList<>();

        // 중복 있는 컬럼 인덱스 리스트
        List<Integer> common = new ArrayList<>();

        for (int i = 0; i < column; i++) {
            Set<String> set = new HashSet<>();

            for (int j = 0; j < relation.length; j++) {
                // 포함하고 있으면 중복되는 컬럼
                if (set.contains(relation[j][i])) {
                    // 중복되는 컬럼의 인덱스를 저장 후 다음 컬럼 탐색
                    common.add(i);
                    break;
                }
                set.add(relation[j][i]);
            }

            // 중복 없는 유니크 컬럼 인덱스 저장
            if (set.size() == relation.length)
                unique.add(i);
        }

        System.out.println("unique=" + unique);
        System.out.println("no unique=" + common);

        // 1. 유니크한 컬럼의 개수는 그대로 정답에 카운트
        answer += unique.size();

        // 2. 중복이 있는 컬럼끼리 조합
        if (common.size() > 1) {

            // 인덱스 조합을 가져오기
            List<List<Integer>> combIdx = makeIndexCombination(common);

            // 정렬 (최소성을 만족하기 위함)
            combIdx.sort(new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> li1, List<Integer> li2) {
                    return li1.size() - li2.size();
                }
            });
            System.out.println(combIdx);

            // 후보키(인덱스 조합) 저장
            Set<Set<Integer>> candidateKey = new HashSet<>();

            // 조합 인덱스 순회하면서 set에 저장하여 후보키 판별
            for (int i = 0; i < combIdx.size(); i++) {
                Set<List<String>> set = new HashSet<>();
                List<Integer> idx = combIdx.get(i); // 후보키 검사할 인덱스 조합

                for (int j = 0; j < relation.length; j++) {
                    List<String> list = new ArrayList<>();

                    for (int k = 0; k < idx.size(); k++) {
                        list.add(relation[j][idx.get(k)]);
                    }

                    if (set.contains(list))
                        break;
                    set.add(list);
                }
                // System.out.println(set);

                // 후보키인 경우 저장 - 이 때, 이미 존재하는 후보키가 부분집합인 경우 제외
                if (set.size() == relation.length) {
                    boolean flag = true;
                    Set<Integer> temp = new HashSet<>(idx);

                    for (Set<Integer> ck : candidateKey) {
                        if (temp.containsAll(ck)) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag)
                        candidateKey.add(temp);
                }
            }

            System.out.println(candidateKey);
            answer += candidateKey.size();
        }

        return answer;
    }

    // 가능한 모든 조합을 생성
    private List<List<Integer>> makeIndexCombination(List<Integer> index) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(index, result, new ArrayList<>(), 0);

        return result;
    }

    private void dfs(List<Integer> index, List<List<Integer>> result, List<Integer> cur, int scope) {
        // cur의 "복사본"을 넣어야 함
        if (!cur.isEmpty())
            result.add(new ArrayList<>(cur));

        for (int i = scope; i < index.size(); i++) {
            cur.add(index.get(i));
            dfs(index, result, cur, i + 1);
            cur.remove(cur.size() - 1);

        }
    }

}