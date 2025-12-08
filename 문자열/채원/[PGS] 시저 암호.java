class Solution {
    public String solution(String s, int n) {
		 String answer = "";
	        char[] r= s.toCharArray();
	        for(int i=0; i<r.length; i++){
	           if(r[i]>='A'&&r[i]<='Z'){
	                if(r[i]=='Z') { //65 A
	                	r[i]=(char) ('A'+(n-1));
	                }
	                
	                else if(r[i]+n>'Z') {
	                	r[i]=(char) (((r[i]-'A'+n)%26)+'A');
	                }
	                else  r[i]+=n;
	                
	            }
	            else if(r[i]>='a'&&r[i]<='z'){
	                if(r[i]=='z') r[i]=(char) ('a'+(n-1));
	                else if(r[i]+n >'z') {
	                	r[i]=(char) (((r[i]-'a'+n)%26)+'a');
	                }
	                else r[i]+=n;
	            }
	        }
	       // System.out.println((char)('y'-25));
	        answer=String.valueOf(r);
	        return answer;
    }
}