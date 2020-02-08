package expert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈주범검거 {
	static int N, M, L;
	static int map[][];
	static int br[][] = { {}, { -1, 1, 0, 0 }, { -1, 1, 0, 0 }, { 0, 0, 0, 0 }, { -1, 0, 0, 0 }, { 0, 1, 0, 0 },
			{ 0, 1, 0, 0 }, { -1, 0, 0, 0 } };
	static int bc[][] = { {}, { 0, 0, -1, 1 }, { 0, 0, 0, 0 }, { 0, 0, -1, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 },
			{ 0, 0, -1, 0 }, { 0, 0, -1, 0 } };

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = s.nextInt();
			M = s.nextInt();
			int sr = s.nextInt();
			int sc = s.nextInt();
			L = s.nextInt();
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = s.nextInt();
				}
			}
			int cnt = 0;
			boolean[][] visited = new boolean[N][M];
			visited[sr][sc] = true;
			cnt++;
			int num = map[sr][sc];
			Queue<Pos> que = new LinkedList<>();
			que.add(new Pos(sr, sc));
			int time = 1;

			while (!que.isEmpty()) {
				if (time >= L)
					break;
				time++;

				int size = que.size();
				for (int i = 0; i < size; i++) {
					Pos p = que.poll();
					num = map[p.r][p.c];

					out : for (int j = 0; j < 4; j++) {
						int nr = p.r + br[num][j];
						int nc = p.c + bc[num][j];
						if (!check(nr, nc) || map[nr][nc] == 0 || visited[nr][nc])
							continue;
						int k = map[nr][nc];
						switch (j) {
						case 0:
							if(br[k][1]==0) {
								continue out; 
							}
							break;
						case 1:
							if(br[k][0]==0)continue out;
							break;
						case 2:
							if(bc[k][3]==0)continue out; 
							break;
						case 3:
							if(bc[k][2]==0)continue out; 
							break;

						default:
							break;
						}
						visited[nr][nc] = true;
						cnt++;
						que.add(new Pos(nr, nc));
					}
				}

			}
			System.out.println("#" + tc + " " + cnt);
		}
	}

	static class Pos {
		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}
