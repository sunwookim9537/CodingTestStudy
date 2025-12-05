class Solution {
    public String solution(String s) {
        String[] words = s.split(" ");
        String result = "";

        for (int w = 0; w < words.length; w++) {
            String word = words[w];
            String converted = "";

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (i % 2 == 0) {
                    converted += Character.toUpperCase(c);
                } else {
                    converted += Character.toLowerCase(c);
                }
            }

            result += converted;

            if (w < words.length - 1) {
                result += " ";
            }
        }
        return result;
    }
}