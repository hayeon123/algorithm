import java.util.Scanner;

public class 팩토리얼 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		factorial(1, N, 1);
	}

	static void factorial(int n, int N, long num) {
		if (n > N) {
			System.out.println(num);
			return;
		}
		factorial(n + 1, N, num * n);
	}

}
