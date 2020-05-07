import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위굴리기 {
	static int R, C;
	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] dice = new int[6];
		st = new StringTokenizer(br.readLine());
		int dir = 0;
		int tmp[] = new int[6];
		for (int i = 0; i < k; i++) {
			dir = Integer.parseInt(st.nextToken());
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (!check(nr, nc))
				continue;
			switch (dir) {
			case 1:
				tmp[0] = dice[2];
				tmp[1] = dice[0];
				tmp[2] = dice[5];
				tmp[3] = dice[3];
				tmp[4] = dice[4];
				tmp[5] = dice[1];
				break;
			case 2:
				tmp[0] = dice[1];
				tmp[1] = dice[5];
				tmp[2] = dice[0];
				tmp[3] = dice[3];
				tmp[4] = dice[4];
				tmp[5] = dice[2];
				break;
			case 3:
				tmp[0] = dice[4];
				tmp[1] = dice[1];
				tmp[2] = dice[2];
				tmp[3] = dice[0];
				tmp[4] = dice[5];
				tmp[5] = dice[3];
				break;
			case 4:
				tmp[0] = dice[3];
				tmp[1] = dice[1];
				tmp[2] = dice[2];
				tmp[3] = dice[5];
				tmp[4] = dice[0];
				tmp[5] = dice[4];
				break;
			default:
				break;
			}
			if(map[nr][nc]==0)map[nr][nc]=tmp[5];
			else {
				tmp[5]=map[nr][nc];
				map[nr][nc]=0; 
			}
			for (int j = 0; j < tmp.length; j++) {
				dice[j]=tmp[j];
			}
			r=nr; 
			c=nc;
			System.out.println(dice[0]);
		}

	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
