package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ≈ª√‚ {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		Queue<Pos> water = new LinkedList<>();
		Queue<Pos> go = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*') {
					water.add(new Pos(i, j));
				} else if (map[i][j] == 'S') {
					go.add(new Pos(i, j));
					map[i][j] = '.';
					visited[i][j] = true;
				}
			}
		}
		int time = 0;

		while (!go.isEmpty()) {
			time++;
			int wSize = water.size();
			for (int i = 0; i < wSize; i++) {
				Pos w = water.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nr = w.r + dr[dir];
					int nc = w.c + dc[dir];
					if (!check(nr, nc))
						continue;
					if (map[nr][nc] == '.') {
						map[nr][nc] = '*';
						water.add(new Pos(nr, nc));
					}
				}
			}
//			System.out.println(time);
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(map[i][j]);
//				}System.out.println();
//			}
			int gSize = go.size();
			for (int i = 0; i < gSize; i++) {
				Pos g = go.poll();

				for (int dir = 0; dir < 4; dir++) {
					int nr = g.r + dr[dir];
					int nc = g.c + dc[dir];
					if (!check(nr, nc) || visited[nr][nc])
						continue;
					if (map[nr][nc] == 'D') {
						System.out.println(time);
						return;
					} else if (map[nr][nc] == '.') {
						go.add(new Pos(nr, nc));
						visited[nr][nc] = true;
					}
				}
			}
		}
		System.out.println("KAKTUS");

	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	static class Pos {
		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
