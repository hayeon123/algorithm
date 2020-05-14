package 기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬탈출2 {
	static int R, C;
	static int[] dr = { -1, 1, 0, 0 };// 상하 좌우
	static int[] dc = { 0, 0, -1, 1 };
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		Pos red = new Pos();
		Pos blue = new Pos();
		int ans = 987654321;
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'R') {
					red.r = i;
					red.c = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					blue.r = i;
					blue.c = j;
					map[i][j] = '.';
				}
			}
		}
		boolean[][][] visited = new boolean[R][C][4];
		Queue<Pos> red_que = new LinkedList<>();
		red_que.add(red);
		Queue<Pos> blue_que = new LinkedList<>();
		blue_que.add(blue);

		out: while (!red_que.isEmpty()) {
			red = red_que.poll();
			blue = blue_que.poll();
			
			f: for (int dir = 0; dir < 4; dir++) {
				int nr = red.r;
				int nc = red.c;
				int b_r = blue.r;
				int b_c = blue.c;
				boolean r_flag = false;
				boolean b_flag = false;
				int r_cnt = 0;
				int b_cnt = 0;
				while (map[nr][nc] != '#') {
					if (map[nr][nc] == 'O') {// goal
						r_flag = true;
						break;
					}
					nr += dr[dir];
					nc += dc[dir];
					r_cnt++;
				}
				while (map[b_r][b_c] != '#') {
					if (map[b_r][b_c] == 'O') {
						b_flag = true;
						break;
					}
					b_r += dr[dir];
					b_c += dc[dir];
					b_cnt++;

				}
				if (r_flag) {
					if (b_flag) {
						continue f;
					} else {
						ans =Math.min(ans, red.cnt + 1);
						break out;
					}
				} else {
					if (b_flag) {
						continue f;
					}
					if (map[nr][nc] == '#') {
						nr -= dr[dir];
						nc -= dc[dir];
					}
					if (map[b_r][b_c] == '#') {
						b_r -= dr[dir];
						b_c -= dc[dir];
					}
					if (nr == b_r && nc == b_c) {
						if (r_cnt > b_cnt) {// red가 뒤에
							nr -= dr[dir];
							nc -= dc[dir];
						} else {
							b_r -= dr[dir];
							b_c -= dc[dir];
						}
					}
					if (red.cnt <  9) {
						red_que.add(new Pos(nr, nc, red.cnt + 1));
						blue_que.add(new Pos(b_r, b_c));
					}
				}
			}

		}
		if (ans == 987654321) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	static class Pos {
		int r, c, cnt;

		Pos() {

		}

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

		Pos(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;

		}
	}

}
