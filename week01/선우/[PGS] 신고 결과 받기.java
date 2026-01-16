import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

class Solution {
 	public int[] solution(String[] id_list, String[] report, int k) {
		
		// 1. 신고자와 피신고자가 같은지 확인
		// 2. 1번이 아닌 경우 그 전에 신고되었는지 확인
		// 3. 1, 2번이 아닌 경우 피신고자의 고발횟수를 카운트++
		// 4. 카운트 횟수가 k이상이면 더 이상 카운트 X
		// 5. 메일을 보내기 위해 신고자 체크
		// 필요한 배열 : 신고자 메일 발신용 배열, 피신고자 고발 횟수 배열
		// 배열 크기 : 신고자 메일 발신용 배열, 피신고자 고발 횟수 배열 모두 id_list와 크기가 같음
		// 중복신고를 막는 것이 포인트 (배열에 넣어 보관) 해당 배열 크기는 n*(n-1) 
		
		int len = id_list.length;
		int[] answer = new int[len]; // 결과 배열 (메일 발신용)
		int[] count = new int[len]; // 신고당한 횟수 배열
		Set<String> set = new HashSet<>();

		for(int i=0;i<report.length;i++) {
			String a = report[i];
			String[] arr = a.split(" ");
			String key = arr[0]+","+arr[1];
			if(arr[0].equals(arr[1])) {
				continue;
			}
			if(set.contains(key)) {
				continue;
			}
			set.add(key);
			for(int j = 0; j < len; j++) {
				if(id_list[j].equals(arr[1])) {
					count[j]++;
				}
			}
		}
		for(int i = 0 ; i< len;i++) {
			for(int j = 0; j < len; j++) {
				if(count[i] >= k && set.contains(id_list[j]+ "," + id_list[i])) {
					answer[j]++;
				}
			}
		}
		return answer;
	}
}