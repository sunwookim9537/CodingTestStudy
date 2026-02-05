import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 정렬: 처리 순서가 꼬이면 손해 볼 수 있어서 정석은 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // lost와 reserve 겹치는 학생 처리용
        boolean[] usedReserve = new boolean[reserve.length];
        boolean[] solvedLost = new boolean[lost.length];

        // 1) 겹치는 학생 먼저 제거: lost에 있으면서 reserve에도 있으면 자기 것만 해결
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (!usedReserve[j] && lost[i] == reserve[j]) {
                    solvedLost[i] = true;   // 이 학생은 체육복 있음(자기 여벌 사용)
                    usedReserve[j] = true;  // 여벌 소진
                    break;
                }
            }
        }

        // 2) 빌려주기: 아직 못 푼 lost 학생에게 reserve의 앞/뒤 번호만 빌려줄 수 있음
        for (int i = 0; i < lost.length; i++) {
            if (solvedLost[i]) continue; // 이미 해결한 학생은 스킵

            int target = lost[i];

            for (int j = 0; j < reserve.length; j++) {
                if (usedReserve[j]) continue;

                int giver = reserve[j];
                if (giver == target - 1 || giver == target + 1) {
                    solvedLost[i] = true;
                    usedReserve[j] = true;
                    break;
                }
            }
        }

        // 3) 정답: 전체 n명 중 체육복 없는 사람 수 = 아직 해결 못한 lost 수
        int notSolved = 0;
        for (boolean ok : solvedLost) {
            if (!ok) notSolved++;
        }

        return n - notSolved;
    }
}