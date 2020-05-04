package 프로그래머스;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Arrays;
public class 프린터 {
	public static  int solution(int[] priorities, int location) {
       Queue<Document> printer = new LinkedList<>(); 
      
        for(int i =0; i<priorities.length; i++) {
        	printer.add(new Document(i, priorities[i]));
        }
        int answer =0; 
        Arrays.sort(priorities);
        int idx =priorities.length-1;
        
        while(!printer.isEmpty()) {
        	
        	Document doc = printer.poll(); 
        	if(priorities[idx]>doc.priority) {
        		printer.add(doc);
        	}else {
        		answer++;
        		if(doc.idx==location)break; 
        		idx--;
        	}
        }
        return answer;
    }
	static class Document {
		int idx; 
		int priority; 
		public Document(int idx, int priority) {
			this.idx = idx; 
			this.priority = priority;
		}		
	}
}
