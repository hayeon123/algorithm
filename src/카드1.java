import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> que = new LinkedList<Integer>(); 
		for (int i = 1; i <= N; i++) {
			que.add(i);
		}
		while(!que.isEmpty()) {
			System.out.print(que.poll());
			if(!que.isEmpty()) {
				System.out.print(" ");
				que.add(que.poll());
			}
		}
	}
}
