import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 국영수  {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Grade> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new Grade(st.nextToken(), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		for (int i = 0; i < N; i++) {
			System.out.println(pq.poll().name);
		}
	}
	static class Grade implements Comparable<Grade>{
		String name; 
		int ko,en, ma;
		Grade(String name, int ko,int en,  int ma){
			this.name = name; 
			this.ko= ko; 
			this.en = en ;
			this.ma=ma;
		}
		
		@Override
		public int compareTo(Grade o) {
			if(this.ko==o.ko) {
				if(this.en==o.en) {
					if(this.ma== o.ma) {
						return this.name.compareTo(o.name);
					}else {
						return o.ma-this.ma;
					}
				}else {
					return this.en-o.en;
				}
			}
			return o.ko-this.ko;
		}
	
	}
}
