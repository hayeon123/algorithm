
import java.util.Scanner;
import java.util.Stack;

public class 스택{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int num = 1;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int idx = 0;

		while (num<=N) {
				stack.push(num);
				sb.append("+").append('\n');
				num++;
			while (!stack.isEmpty() && idx < arr.length && arr[idx] == stack.peek()) {
				stack.pop();
				sb.append("-").append('\n');
				idx++;
			}
		}
		if (stack.isEmpty()) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}

	}
}
