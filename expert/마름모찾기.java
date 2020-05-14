package expert;

import java.util.Scanner;

public class 마름모찾기 {
	static int dr[] = { 1, 1, -1, -1 };
	static int dc[] = { 1, -1, -1, 1 };
	static int map[][];
	static int N;
	static int M;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][M];
			max = 0;
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						max = Math.max(max, 1);
						if (Math.min(Math.min(j, M - j), N - i) > max) {
							solution(i, j, i, j, 1, 1, 0);

						}

					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}

	}

	static void solution(int sr, int sc, int r, int c, int len, int cnt, int dir) {
		if (dir == 3 && sr == r && sc == c) {
			max = Math.max(len, max);
			return;
		}
		if (dir == 0) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (check(nr, nc) && map[nr][nc] == 1) {
				solution(sr, sc, nr, nc, len + 1, len + 1, 0);
			}
			nr = r + dr[dir + 1];
			nc = c + dc[dir + 1];
			if (check(nr, nc) && map[nr][nc] == 1) {
				solution(sr, sc, nr, nc, len, 2, dir + 1);
			}
		} else {
			if (cnt < len) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (check(nr, nc) && map[nr][nc] == 1) {
					solution(sr, sc, nr, nc, len, cnt + 1, dir);
				}
			} else if (cnt == len && dir < 3) {
				int nr = r + dr[dir + 1];
				int nc = c + dc[dir + 1];
				if (check(nr, nc) && map[nr][nc] == 1) {
					solution(sr, sc, nr, nc, len, 2, dir + 1);
				}
			}
		}
	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}
