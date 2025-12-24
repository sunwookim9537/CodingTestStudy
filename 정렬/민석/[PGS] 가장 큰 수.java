import java.util.*;

class Solution {
    public String solution(int[] numbers) {

        // 문자열로 붙여서 정렬해서 비교하면되지않을까
        //강사님이 자바수업때 알려준 comparator오버라이딩 ㄱㄱ
        
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        //남자는 람다함수 안씀
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String x,String y) {
                
                return (y+x).compareTo(x+y); 
            }
        };

    
        Arrays.sort(arr, comparator);
        //0이면
        if (arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }
}
