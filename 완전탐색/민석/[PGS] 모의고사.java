class Solution {
    public int[] solution(int[] answers) {

        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        int max = 0;
        int N = answers.length;
        int a = 1;

        // 1번 수포자
        for (int i = 0; i < N; i++) {
            if (a == answers[i]) cnt1++;
            if (a == 5) a = 0;
            a++;
        }
        max = Math.max(max, cnt1);

        // 2번 수포자
        a = 1;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                if (answers[i] == 2) cnt2++;
            } else {
                if (a == 6) a = 1;
                if (a == 2) a++;
                if (answers[i] == a) cnt2++;
                a++;
            }
        }
        max = Math.max(max, cnt2);

        // 3번 수포자
        a = 1;
        for (int i = 0; i < N; i++) {
            if (a >= 11) a = 1;

            if ((a == 1 || a == 2) && answers[i] == 3) cnt3++;
            if ((a == 3 || a == 4) && answers[i] == 1) cnt3++;
            if ((a == 5 || a == 6) && answers[i] == 2) cnt3++;
            if ((a == 7 || a == 8) && answers[i] == 4) cnt3++;
            if ((a == 9 || a == 10) && answers[i] == 5) cnt3++;

            a++;
        }
        max = Math.max(max, cnt3);

        
        if (cnt1 == max && cnt2 == max && cnt3 == max) {
            return new int[]{1, 2, 3};
        }
        if (cnt1 == max && cnt2 == max) {
            return new int[]{1, 2};
        }
        if (cnt1 == max && cnt3 == max) {
            return new int[]{1, 3};
        }
        if (cnt2 == max && cnt3 == max) {
            return new int[]{2, 3};
        }
        if (cnt1 == max) {
            return new int[]{1};
        }
        if (cnt2 == max) {
            return new int[]{2};
        }
        return new int[]{3}; 
    }
}
