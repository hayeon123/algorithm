package 프로그래머스;

public class 쇠막대기 {
	 public int solution(String arrangement) {
	        int answer = 0;
	        int cnt =0; 
	        char last ='(';
	        for(int i =0 ;i<arrangement.length(); i++){
	            if(arrangement.charAt(i)=='('){
	                cnt++; 
	                last ='(';
	            }else{
	                if(last=='('){
	                    cnt--; 
	                    answer+=cnt;
	                }else{
	                    answer++; 
	                    cnt--; 
	                }
	                last =')';
	                
	            }
	        }
	        return answer;
	    }
}
