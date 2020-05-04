import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀 {
	static int N, K, L;
	static int[][] map;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 }; // �����»�

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}
		L = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int next_time = Integer.parseInt(st.nextToken());
		char next_dir = st.nextToken().charAt(0);
		map[0][0] = 2;
		Queue<Snake> que = new LinkedList<>();
		que.add(new Snake(0, 0));
		int r = 0;
		int c = 0;
		int time = 0;
		int dir = 0;
		int cnt = 0;
		while (true) {
			time++;
//			System.out.println(time);
			r += dr[dir];
			c += dc[dir];
			if (!check(r, c) || map[r][c] == 2) {
				break;
			}
			if (map[r][c] == 1) {// ���
				que.add(new Snake(r, c));
				map[r][c] = 2;
			} else {
				que.add(new Snake(r, c));
				map[r][c]=2;
				Snake tail = que.poll();
				map[tail.r][tail.c] = 0;
			}
//			System.out.println(time
//					);
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			if (time == next_time) {
				dir = change_dir(dir, next_dir);
				if (cnt < L-1) {
					st = new StringTokenizer(br.readLine());
					next_time = Integer.parseInt(st.nextToken());
					next_dir = st.nextToken().charAt(0);
					cnt++;
				}
			}
		}
		System.out.println(time);
	}

	static int change_dir(int dir, char d) {
		if (d == 'L') {
			dir--;
			if (dir < 0) {
				dir = 3;
			}
		} else {
			dir++;
			if (dir == 4) {
				dir = 0;
			}
		}
		return dir;
	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

	static class Snake {
		int r, c;

		Snake(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
