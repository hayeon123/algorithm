package 프로그래머스;
import java.util.*;

public class 베스트앨범 {
	
	
	public static int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> genreMap = new HashMap<>(); 
		HashMap<String, Integer> musicMap = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < plays.length; i++) {
			if(genreMap.containsKey(genres[i])) {
				genreMap.put(genres[i], genreMap.get(genres[i])+plays[i]);
			}else {
				genreMap.put(genres[i], plays[i]);
			}
		}
		
		
		
		
		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i]=list.get(i);
		}
		return answer; 
	}
}
