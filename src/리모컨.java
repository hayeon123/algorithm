import java.util.Scanner;

public class 리모컨 {
	static boolean button[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		button = new boolean[10];
		for (int i = 0; i < M; i++) {
			button[sc.nextInt()] = true;
		}
		int min = Math.abs(N - 100);
		int down = 1000000;
		while (down >= 0) {
			if (isPossible(down)) {
				min = Math.min(min, (down + "").length() + Math.abs(down - N));
			}
			down--;
		}
		System.out.println(min);
	}

	static boolean isPossible(int channel) {
		String st = channel + "";
		char[] num = st.toCharArray();
		for (char n : num) {
			if (button[n - 48]) {
				return false;
			}
		}
		return true;
	}
}
