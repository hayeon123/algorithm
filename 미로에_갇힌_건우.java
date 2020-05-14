import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로에_갇힌_건우 {
	static int N, M;
	static int map[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int max;
	static String day = "sun";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		max = 987654321;
		int visited[][] = new int[N][N];
		char visit[][] = new char[N][N];
		for (int i = 0; i < visited.length; i++) {
			Arrays.fill(visited[i], 987654321);
		}
		Queue<Pos> que = new LinkedList<>();
		que.add(new Pos(0, 0, 1, 0, 0)); //
		
		visited[0][0] = 1;
		visit[0][0] = 's';

		while (!que.isEmpty()) {
			Pos pos = que.poll();
			if(pos.r==N-1 && pos.c==N-1)continue;
			out: for (int d = 0; d < 4; d++) {
				int nr = pos.r + dr[d];
				int nc = pos.c + dc[d];

				if (!check(nr, nc))
					continue;
				
				int t = pos.t;
				int m = pos.m ;
				int cnt = pos.cnt;

				
				if (map[nr][nc] == 1 && pos.t==1) {
					while(map[nr][nc]==1) {
						nr = nr+dr[d];
						nc = nc+dc[d];
						if(!check(nr,nc)) continue out;
					}
				} else if(map[nr][nc]==1 && pos.t ==0) {
					continue;
				}
				
				
				
				if (visited[nr][nc] < cnt)
					continue;

				if (visited[nr][nc] > cnt) {
					
					visited[nr][nc] = cnt;
					if(t==0) {
						visit[nr][nc]='s';
					}else {
						visit[nr][nc]='m';
					}
				} else if (visited[nr][nc] == cnt) {
					if (visit[nr][nc] == 's') {
						continue;
					} else if (t == 0 && visit[nr][nc] == 'm') {
						visit[nr][nc] = 's';
					}
				}
				
				if (m+1 > M) { 
					m = 0;
				} else if (m+1 == M) {
					m++;
					if (t % 2 == 1) { // 밤에서 낮으로 바뀔때 하루가 지남
						cnt++;
					}
					t = (t + 1) % 2;
				}else {
					m++;
				}
				que.add(new Pos(nr,nc,cnt,m, t));
			}

		}
		for (int i = 0; i < visit.length; i++) {
			for (int j = 0; j < visit.length; j++) {
				if(visited[i][j]==987654321)System.out.print(0);
				else System.out.print(visited[i][j]);
			}System.out.println();
		}
		for (int i = 0; i < visit.length; i++) {
			for (int j = 0; j < visit.length; j++) {
				System.out.print(visit[i][j]);
			}System.out.println();
		}

		if (visited[N - 1][N - 1] == 987654321) {
			System.out.println(-1);
		} else {
			if(visit[N-1][N-1]=='s')
			System.out.println(visited[N-1][N-1] + " sun" );
			else
				System.out.println(visited[N-1][N-1] + " moon" );
		}

	}

	static class Pos {
		int r, c;
		int cnt, m;
		int t;

		Pos(int r, int c, int cnt, int m, int t) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.m = m;
			this.t = t; // 0= 낮, 1=저
//			this.dir = dir;
		}

	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
