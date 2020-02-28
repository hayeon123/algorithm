package expert;

import java.util.Scanner;

public class 암호문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 1; tc++) {
			int N = sc.nextInt();
			String[] list = new String[N];

			for (int i = 0; i < N; i++) {
				list[i] = sc.next();
			}
			int order = sc.nextInt();
			int x = 0, y = 0;
			for (int i = 0; i < order; i++) {
				String str = sc.next();
				x = sc.nextInt();
				y = sc.nextInt();
				System.out.println(x+" "+y);
				for (int j = x; j < x + y; j++) {
					System.out.println(j);
					if (j >= 10) {
						String st = sc.next();
						System.out.println(st);
					} else {
						if (j + y < 10)
							list[j + y] = list[j];
						list[j] = sc.next();
						System.out.println(j+" "+list[j]);
					}

				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);
			for (int i = 0; i < 10; i++) {
				sb.append(" ").append(list[i]);
			}
			System.out.println(sb);
		}
	}
}
