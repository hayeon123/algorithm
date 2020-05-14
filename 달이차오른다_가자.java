import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 달이차오른다_가자 {
	static int R, C;
	static char[][] map;

	public static void main(String[] args) {
//		System.out.println('A' - 0);// 65
//		System.out.println('F' - 0);// 70
//		System.out.println('a' - 0);// 97
//		System.out.println('f' - 0);// 102
//		System.out.println('a' - 'A');// 32
//		System.out.println('f' - 'F');
//		System.out.println(1<<'C');
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		Pos ms = new Pos(0, 0, 0, 0);
		for (int i = 0; i < R; i++) {
			map[i] = sc.next().toCharArray();
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == '0') {
					ms.r = i;
					ms.c = j;
					map[i][j] = '.';
				}
			}
		}
		Queue<Pos> que = new LinkedList<Pos>();
		que.add(ms);
		int answer =987654321;
		boolean[][][] visited = new boolean[R][C][64];
		while (!que.isEmpty()) {
			Pos p = que.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = p.r+dr[dir]; 
				int nc = p.c+dc[dir]; 
				if(!check(nr,nc)||map[nr][nc]=='#'||visited[nr][nc][p.key])continue; 
				if(map[nr][nc]=='1') {
					answer= Math.min(answer, p.cnt+1);
					visited[nr][nc][p.key]=true; 
				}
				else if(map[nr][nc]=='.') {
					que.add(new Pos(nr,nc,p.key,p.cnt+1));
					visited[nr][nc][p.key]=true;
				}else if(map[nr][nc]>='A'&&map[nr][nc]<='F') {
					if( (p.key&(1<<(map[nr][nc]-'A'))) != 0) { //key가 있을 때 
						que.add(new Pos(nr,nc,p.key, p.cnt+1));
						visited[nr][nc][p.key]=true;
					}
				}else if(map[nr][nc]>='a'&& map[nr][nc]<='f') {
					int tmp_key = p.key|(1<<map[nr][nc]-'a');
					que.add(new Pos(nr,nc,tmp_key, p.cnt+1));
					visited[nr][nc][tmp_key]=true;
				}
			}
		}
		if(answer==987654321) {
			System.out.println("-1");
		}else {
			System.out.println(answer);
		}
	}

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static class Pos {
		int r, c;
		int key;
		int cnt;

		Pos(int r, int c, int key, int cnt) {
			this.r = r;
			this.c = c;
			this.key = key;
			this.cnt = cnt;
		}
	}

	static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}
