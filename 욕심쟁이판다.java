import java.util.Scanner;

public class 욕심쟁이판다 {
	static int N;
	static int[][] map;
	static int[][] memo;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int max;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		memo = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				memo[i][j] = -1;
			}
		}
		max = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(memo[i][j]==-1)recur(i,j);
			}
		}
		System.out.println(max);
	}

	static void recur(int r, int c) {
		if (memo[r][c] == -1)
			memo[r][c] = 1; // 한번도 방문 안한 곳이였으면
		int tmp = 0;
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (!check(nr, nc) || map[nr][nc] <= map[r][c])
				continue;
			if (memo[nr][nc] == -1) {
				recur(nr, nc);
			}
			tmp = Math.max(tmp, memo[nr][nc]);
		}
		memo[r][c]+=tmp;
		max=Math.max(memo[r][c],max);
	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}
