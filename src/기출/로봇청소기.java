package 기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기 {
	static int R, C;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 }; // 북 동 남 서

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		boolean flag = false;
		out: while (true) {
			if (map[r][c] == 0) {
				map[r][c] = 2;
				cnt++;
			}
			for (int i = 0; i < 4; i++) {
				dir = change_dir(dir);
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (map[nr][nc] == 0) {
					r = nr;
					c = nc;
					continue out;
				}
			}
			//방향을 유지하고 한칸 후진 
			int back = (dir+2)%4; 
			int nr = r+dr[back];
			int nc = c+dc[back];
			if(map[nr][nc]!=1) {
				r= nr; 
				c = nc; 
				continue out; 
			}else {
				break;
			}
			//후진 할 수 없는 경우는 break; 
			
		}
		System.out.println(cnt);

	}

	static int change_dir(int dir) {
		switch (dir) {
		case 0:// 북 2
			dir = 3;
			break;
		case 1:// 동 3
			dir = 0;
			break;
		case 2:// 남 0 
			dir = 1;
			break;
		case 3:// 서 2 
			dir = 2;
			break;
		default:
			break;
		}
		return dir;
	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

}
