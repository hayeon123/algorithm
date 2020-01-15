import java.util.ArrayList;
import java.util.Scanner;

//3190
public class 뱀 {
	static int N; // 보드듸 크기
	static int K; // 사과의 개수
	static int[][] map;
	static int L;// 뱀의 방향 변환 횟수
	static int dr[] = { 0, 1, 0, -1 };// 오른쪽, 아래 , 왼쪽, 위
	static int dc[] = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N + 1][N + 1];
		for (int i = 0; i < K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			map[r][c] = 9;
		}
		L = sc.nextInt();// 뱀의 방향 변환 횟수
		Order[] order = new Order[L];
		for (int i = 0; i < L; i++) {
			order[i] = new Order(sc.nextInt(), sc.next().charAt(0));
		}
		ArrayList<Pos> snake = new ArrayList<>();
		snake.add(new Pos(1, 1, 0));
		map[1][1] = 1;
		int idx = 0;
		int time = 0;
		int head = 0;
		int tail = 0;

		
		while (true) {
			time++;
			int dir = snake.get(head).dir;
			int nr = snake.get(head).r + dr[dir];
			int nc = snake.get(head).c + dc[dir];

			if (!check(nr, nc) || map[nr][nc] == 1)
				break;
			if (map[nr][nc] == 9) {
				
			} else {// 0
				map[snake.get(tail).r][snake.get(tail).c]=0;
				tail++;
			}
			snake.add(new Pos(nr, nc, dir));
			head++;
			map[nr][nc] = 1;

			if (idx<order.length && time == order[idx].time) {
				snake.get(head).dir= getDir(dir,order[idx].dir);
				idx++;
			}
//			System.out.println("time="+ time+" headDir="+snake.get(head).dir);
//			for (int i = 0; i <= N; i++) {
//				for (int j = 0; j <= N; j++) {
//					System.out.print(map[i][j]);
//				}System.out.println();
//			}
		}

		System.out.println(time);
	}
	static int getDir(int d, int c) {
		if(c=='D') {
			d++;
		}else if(c=='L') {
			d--;
		}
		if(d>3)d=0; 
		else if(d<0)d=3;
		
		return d;
	}
	static boolean check(int r, int c) {
		return r <= N && c <= N && r > 0 && c > 0;
	}

	static class Order {
		int time;
		char dir;

		Order(int time, char dir) {
			this.time = time;
			this.dir = dir;
		}
	}

	static class Pos {
		int r, c, dir;

		Pos(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
}
