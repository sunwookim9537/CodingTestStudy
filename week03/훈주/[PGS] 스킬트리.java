class Solution {
    public int solution(String skill, String[] skill_trees) {

        int count = 0;

        for (String tree : skill_trees) {

            StringBuilder filtered = new StringBuilder();

            // 1. 선행 스킬만 추출
            for (char c : tree.toCharArray()) {
                if (skill.contains(String.valueOf(c))) {
                    filtered.append(c);
                }
            }

            // 2. 순서 검증
            if (skill.startsWith(filtered.toString())) {
                count++;
            }
        }

        return count;
    }
}