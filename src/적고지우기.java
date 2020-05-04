
import java.util.ArrayList;
import java.util.Scanner;

public class 적고지우기  {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int T = sc.nextInt();
		for(int tc= 1; tc<=T; tc++) {
			char[] num = sc.next().toCharArray();
			ArrayList<Character> list = new ArrayList<>();
			for (int i = 0; i < num.length; i++) {
				if(!list.contains(num[i]))list.add(num[i]);
				else list.remove(list.indexOf(num[i]));
			}
			
			System.out.println("#"+tc+" "+list.size());
		}
	}
}
