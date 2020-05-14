import java.util.Scanner;

public class NM과K {
	static int max = -987654321;
	static int R, C;
	static int dr[] = { -1, 0 };
	static int dc[] = { 0, -1 };
	static int map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		int K = sc.nextInt();
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		boolean[][] visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				visited[i][j]=true;
				select(0, new Pos[K], i, j, visited);
				visited[i][j]=false;
			}
		}
		
		System.out.println(max);

	}

	static void select(int idx, Pos[] select, int r, int c, boolean[][] visited) {
		select[idx] = new Pos(r, c);
		if (idx == select.length - 1) {
			int sum = 0;
			for (int i = 0; i < select.length; i++) {
				sum += map[select[i].r][select[i].c];
				//System.out.println(select[i].r+" "+select[i].c+" ");
			}//System.out.println();
			max = Math.max(max, sum);
			return;
		}

		if (c + 2 < C) {
			out: for (int i = c + 2; i < C; i++) {
				cn: for (int d = 0; d < 2; d++) {
					int nr = r + dr[d];
					int nc = i + dc[d];
					if (!check(nr, nc))
						continue cn;
					if (visited[nr][nc])
						continue out;

				}
				visited[r][i] = true;
				select(idx + 1, select, r, i, visited);
				visited[r][i] = false;
			}
		}
		if (r + 1 < R) {
			for (int i = r + 1; i < R; i++) {
				out: for (int j = 0; j < C; j++) {
					cn: for (int d = 0; d < 2; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (!check(nr, nc))
							continue cn;
						if (visited[nr][nc])
							continue out;
					}
					visited[i][j] = true;
					select(idx + 1, select, i, j, visited);
					visited[i][j] = false;
				}
			}
		}
	}

	static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

	public static class Pos {
		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
