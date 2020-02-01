import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class 듣보잡 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		TreeMap<String, String> t1 = new TreeMap<>();
		
		for (int i = 0; i < N; i++) {
			t1.put(sc.next(), "");
		}
		int idx =0;
		int cnt = 0;
		
		TreeMap<Integer,String>t2 = new TreeMap<>();
		ArrayList<String>list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			t2.put(i, sc.next());
		}
		
		for (int i = 0; i < t2.size(); i++) {
			if(t1.containsKey(t2.get(i))) {
				list.add(t2.get(i));
				cnt++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append('\n');
		for (int i = 0; i < idx; i++) {
			sb.append(list.get(i)).append('\n');
		}
		System.out.println(sb);
	}
}
