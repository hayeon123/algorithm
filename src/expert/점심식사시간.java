package expert;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 점심식사시간 {
	static class Person implements Comparable<Person> {
		int r, c;

		Person(int r, int c) {
			this.r = r;
			this.c = c;
			dist = new int[2];
		}

		int[] dist;
		int sel;// 자신에게 배정된 계단 번호

		@Override
		public int compareTo(Person o) {
			return this.dist[this.sel] - o.dist[o.sel];
		}

	}

	static class Stair {
		int r, c, height;

		public Stair(int r, int c, int height) {
			super();
			this.r = r;
			this.c = c;
			this.height = height;
		}

	}

	static int[][] map;
	static int N;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// N*N을 순회하면서 입력을 받는데,
			// 사람일 경우 사람정보를 저장(행,열 좌표)
			// 계단일 경우 계단 배열에 계단 정보를 저장 (행, 열 좌표, 깊이)
			ans = Integer.MAX_VALUE;
			N = sc.nextInt();
			map = new int[N][N];
			int sCnt = 0;
			int pCnt = 0;
			Stair[] stairs = new Stair[2];
			Person[] person = new Person[10];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 0) {
						continue;
					} else if (map[i][j] == 1) {
						person[pCnt++] = new Person(i, j);
					} else {
						stairs[sCnt++] = new Stair(i, j, map[i][j]);
					}
				}
			}
			for (int i = 0; i < pCnt; i++) {
				for (int j = 0; j < sCnt; j++) {
					person[i].dist[j] = Math.abs(person[i].r - stairs[j].r) + Math.abs(person[i].c - stairs[j].c)+1;
				}
			}
			powerSet(person, stairs, 0, pCnt);
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void powerSet(Person[] person, Stair[] stairs, int idx, int pCnt) {
		if (idx == pCnt) {
			// 모든 사람에게 계단이 배정됨
			int[][] timeTable = new int[2][200];
			PriorityQueue<Person> pq = new PriorityQueue<>();
			int max = 0;
			for (int i = 0; i < pCnt; i++) {
				pq.add(person[i]);
			}
			while (!pq.isEmpty()) {
				Person p = pq.poll();
				int from = p.dist[p.sel];
				int to = from + stairs[p.sel].height;
				for (int j = from; j < to; j++) {
					if (timeTable[p.sel][j] == 3) {
						to++;
						continue;
					}
					timeTable[p.sel][j]++;
				}
				if (max < to) {
					max = to;
				}
			}

			ans = Math.min(ans, max);

			return;
		}
		person[idx].sel = 0;
		powerSet(person, stairs, idx + 1, pCnt);
		person[idx].sel = 1;
		powerSet(person, stairs, idx + 1, pCnt);

	}
}

