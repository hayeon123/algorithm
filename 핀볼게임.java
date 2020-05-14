import java.util.Scanner;

public class 핀볼게임 {
	static int map[][];
	static int N;
	static int max;
	static Pos[][] hole;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			max = 0;
			hole = new Pos[11][2];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] >= 6 && map[i][j] <= 10) {
						int k = map[i][j];
						if (hole[k][0] == null) {
							hole[k][0] = new Pos(i, j, 0, 0);
						} else {
							map[i][j] *= -1;
							hole[k][1] = new Pos(i, j, 0, 0);
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int d = 0; d < 4; d++) {
						if (map[i][j] == 0)
							solution(i, j, d);
//						System.out.println(max);
					}
				}
			}
//			solution(2,3,0);
			System.out.println("#" + tc + " " + max);

		}
	}

	static void solution(int start_r, int start_c, int start_dir) {
		Pos ball = new Pos(start_r+dr[start_dir], start_c+dc[start_dir], start_dir, 0);

		while (true) {
//			System.out.println(ball.cnt);
			// 벽 만났을 때
			if (!check(ball.r, ball.c) || map[ball.r][ball.c] == 5) {
				ball.cnt++;
				ball.dir = dirChange(ball.dir);
				ball.r += dr[ball.dir];
				ball.c += dc[ball.dir];
				
			} else if (ball.r == start_r && ball.c == start_c) {// 원래 자리로 돌아왔을때
				max = Math.max(max, ball.cnt);
				return;
			} else if (map[ball.r][ball.c] == -1) {// 블랙홀
				max = Math.max(max, ball.cnt);
				return;
			} else if (map[ball.r][ball.c] == 0) { // 그냥 전
				ball.r+= dr[ball.dir];
				ball.c+= dc[ball.dir];
//				System.out.println(ball.r+" "+ball.c);
			} else if (map[ball.r][ball.c] >= 1 && map[ball.r][ball.c] <= 4) {// 블럭
				ball.cnt++;
				ball = dirChange(ball, ball.dir, map[ball.r][ball.c]);
				ball.r+= dr[ball.dir];
				ball.c+= dc[ball.dir];
				
			} else if (map[ball.r][ball.c] >= 6 && map[ball.r][ball.c] <= 10) {// 웜홀
				int wh = map[ball.r][ball.c];
				ball.r = hole[wh][1].r+dr[ball.dir];
				ball.c = hole[wh][1].c+dc[ball.dir];
				
			} else if (map[ball.r][ball.c] <= -6 && map[ball.r][ball.c] >= -10) {// 웜홀
				int wh = map[ball.r][ball.c] * -1;
				ball.r = hole[wh][0].r+dr[ball.dir];
				ball.c = hole[wh][0].c+dc[ball.dir];
			} 

		}

	}

	static Pos dirChange(Pos pos, int dir, int block) {
		switch (block) {
		case 1:
			if (dir == 1) {
				dir = 0;
			} else if (dir == 2) {
				dir = 3;
			} else {
				dir = dirChange(dir);
			}
			break;
		case 2:
			if (dir == 2) {
				dir = 1;
			} else if (dir == 3) {
				dir = 0;
			} else {
				dir = dirChange(dir);
			}
			break;
		case 3:
			if (dir == 0) {
				dir = 1;
			} else if (dir == 3) {
				dir = 2;
			} else {
				dir = dirChange(dir);
			}
			break;
		case 4:
			if (dir == 0) {
				dir = 3;
			} else if (dir == 1) {
				dir = 2;
			} else {
				dir = dirChange(dir);
			}
			break;

		default:
			break;
		}

		pos.dir = dir;
		return pos;
	}

	static int dirChange(int dir) {
		switch (dir) {
		case 0:
			dir = 2;
			break;
		case 1:
			dir = 3;
			break;
		case 2:
			dir = 0;
			break;
		case 3:
			dir = 1;
			break;

		default:
			break;
		}

		return dir;
	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

	static class Pos {
		int r, c;
		int dir;
		int cnt; // 방향 전환 횟수

		Pos(int r, int c, int dir, int cnt) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cnt = cnt;
		}
	}

	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
}
