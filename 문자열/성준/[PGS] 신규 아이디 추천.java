    /*
        3<= new_id.length <= 15;
        new id 오로지 소문자 이거 혹시 .toLowerCase()
        그리고 -,_,. 가능
        처음과 끝 . 안돼 연속 안돼
        너무많음 박스 내용 보자
    */
class Solution {
        public String solution(String new_id) {

            // 소문자만 가능
            new_id = new_id.toLowerCase();
            //System.out.println(new_id);

            //잠만 이거 정규식 작성법 알아야 하는거 아님? 나 밑에거 밖에 모른는데
            // 되는거 - , _ , . 그리고 소문자, 숫자
            new_id  = new_id.replaceAll("[^0-9a-z-_.]","");

            // 연속된.을 .하나로 바꿔
            new_id = new_id.replaceAll("\\.{2,}", ".");

            // 첨과 끝 . 안돼
            new_id = new_id.replaceAll("^[.]", "");
            new_id = new_id.replaceAll("[.]$", "");

            // 빈 문자열이야 그럼 a 넣어
            if(new_id.length() == 0){
                new_id = "a";
            }

            // new_id 길이가 16자 이상이면 15까지만 잘라 substring(0,15) 쓰자
            // 근데 제거를 했는데 마지막이 .이야 제거  replaceAll 쓰자는거잖아.
            if(new_id.length() > 15){
                new_id = new_id.substring(0,15);
                new_id = new_id.replaceAll("[.]$","");
            }

            // 3자 미만이야 그럼 마지막 문자 반복하자
            while(new_id.length() < 3){
                new_id += new_id.charAt(new_id.length()-1);
            }

            return new_id;
        }
    }