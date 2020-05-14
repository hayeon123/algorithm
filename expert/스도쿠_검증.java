package expert;

import java.util.Scanner;

public class 스도쿠_검증 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		out: for (int tc = 1; tc <= T; tc++) {
			int map[][] = new int[9][9];

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int r = 0; r < 9; r++) {
				int sum_r = 0;
				int sum_c = 0;
				for (int i = 0; i < map.length; i++) {
					sum_r += map[r][i];
					sum_c += map[i][r];
				}
				if (sum_r != 45 || sum_c != 45) {
					System.out.println("#" + tc + " " + 0);
					continue out;
				}
			}
			for (int i = 0; i < map.length; i += 3) {
				for (int j = 0; j < map.length; j += 3) {
					int sum = 0;
					for (int k = i; k < i + 3; k++) {
						for (int k2 = j; k2 < j + 3; k2++) {
							sum += map[k][k2];
						}
					}
					if (sum != 45) {
						System.out.println("#" + tc + " " + 0);
						continue out;
					}

				}
			}
			System.out.println("#" + tc + " " + 1);

		}
	}

	static boolean row(int r, int map[][]) {
		boolean check = true;

		return check;
	}
}
