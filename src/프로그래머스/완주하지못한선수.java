package 프로그래머스;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class 완주하지못한선수 {
	public static void main(String[] args) {
		
	}
	
	  public static String solution(String[] participant, String[] completion) {
	        String answer = "";
	        Map<String, Integer> ph = new HashMap<>();
	        
	        for (String p : participant) {
				if(ph.containsKey(p)) {
					ph.put(p, ph.get(p)+1);
				}else {
					ph.put(p, 1);
				}
			}
	        for (String c : completion) {
				ph.put(c, ph.get(c)-1);
			}
	        for (String p : ph.keySet()) {
				if(ph.get(p)>0) {
					answer = p; 
					break;
				}
			}
	        return answer;
	    }
}
