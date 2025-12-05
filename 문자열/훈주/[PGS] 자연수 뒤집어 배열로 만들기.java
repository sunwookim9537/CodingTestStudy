class Solution {
    public int[] solution(long n) {
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }
}

/*
class Solution {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        int len = s.length();
        int[] answer = new int[len];
        
        for (int i = 0; i < len; i++) {
            answer[i] = s.charAt(len - 1 -i) - '0';
        }
        return answer;
    }
}
*/