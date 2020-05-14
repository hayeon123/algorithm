package expert;

import java.util.Arrays;
import java.util.Scanner;

public class 미생물격리 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M, K;
	static Pos map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();

			map = new Pos[N][N];
			Pos[] list = new Pos[K];
			for (int i = 0; i < K; i++) {
				list[i] = (new Pos(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt() - 1, i, true));
			}
			int time = 0;

			while (time < M) {
				for (int i = 0; i < N; i++) {
					Arrays.fill(map[i], null);
				}
				
				for (int i = 0; i < list.length; i++) {
					if (!list[i].die)
						continue; // 죽었으면
					int nr = list[i].r + dr[list[i].dir];
					int nc = list[i].c + dc[list[i].dir];
					if (check(nr, nc)) {// 약품
						list[i].cnt /= 2;
						if (list[i].cnt <= 0) {
							list[i].die = false;
							continue;
						}
						list[i].dir = changeDir(list[i].dir);
						list[i].r= nr; 
						list[i].c = nc;
						continue;
					}
					if(map[nr][nc]==null) {
						map[nr][nc] = new Pos(nr, nc, list[i].cnt, list[i].dir, list[i].idx, true);
					}
					else  {
						if (map[nr][nc].cnt < list[i].cnt) {// 내가 더 많은 경우
							
							list[map[nr][nc].idx].die = false;
							map[nr][nc].cnt = list[i].cnt;// max값 변경 내껄로
							map[nr][nc].dir = list[i].dir;// 방향 바꿈
							list[i].cnt += list[map[nr][nc].idx].cnt;
							map[nr][nc].idx = i;// 인덱스 바꿈
						} else {// 내가 더 작으면
							list[i].die = false; // 죽고
							list[map[nr][nc].idx].cnt += list[i].cnt; // 원래 있던 애한테는 플러스
						}
					}
					list[i].r = nr;
					list[i].c = nc;
				}

				time++;
			}
			int result = 0;
			for (int i = 0; i < list.length; i++) {
				if (list[i].die) {
					result += list[i].cnt;
//					System.out.println(list[i].cnt);
				}
				;
			}
			System.out.println("#" + tc + " " + result);

		}
	}

	static int changeDir(int d) {
		switch (d) {
		case 0:
			d = 1;
			break;
		case 1:
			d = 0;
			break;
		case 2:
			d = 3;
			break;
		case 3:
			d = 2;
			break;

		default:
			break;
		}
		return d;
	}

	static class Pos {
		int r, c, cnt, dir, idx;
		boolean die;

		Pos(int r, int c, int cnt, int dir, int idx, boolean die) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
			this.idx = idx;
			this.die = die;
		}
	}

	static boolean check(int r, int c) {
		return r == 0 || c == 0 || r == N - 1 || c == N - 1;
	}
}
