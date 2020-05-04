package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노 {
	static int R, C;
	static int[][] map;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;
		bar(); 
		square();
		trio();
		System.out.println(max);
	}

	static void bar() {
		for (int i = 0; i < R; i++) {
			int sum = 0;
			for (int j = 0; j < 4; j++) {
				sum += map[i][j];
			}
			max = Math.max(max, sum);
			for (int j = 4; j < C; j++) {
				sum += map[i][j];
				sum -= map[i][j - 4];
				max = Math.max(max, sum);
			}
		}
		for (int j = 0; j < C; j++) {
			int sum = 0;
			for (int i = 0; i < 4; i++) {
				sum += map[i][j];
			}
			max = Math.max(max, sum);
			for (int i = 4; i < R; i++) {
				sum += map[i][j];
				sum -= map[i-4][j];
				max = Math.max(max, sum);
			}
		}
	}

	static void square() {
		int sum = 0;
		for (int j = 0; j < C-1; j++) {
			for (int i = 0; i < R - 1; i++) {
				sum=map[i][j]+map[i+1][j];
				int next =0; 
				if(i>0) {
					next = map[i-1][j+1]+map[i][j+1];
					max=Math.max(max, sum+next);
				}
				if(i+2<R) {
					next =map[i+1][j+1]+map[i+2][j+1];
					max =Math.max(max, sum+next);
				}
				next = map[i][j+1]+map[i+1][j+1];
				max=Math.max(max, sum+next);
			}
		}
		
		sum = 0;
		for (int i = 1; i < R; i++) {
			sum = map[i - 1][0];
			for (int j = 0; j < C - 1; j++) {
				sum += map[i - 1][j + 1];
				int next = 0;
				if (j - 1 >= 0) {
					next = map[i][j - 1] + map[i][j];
					max = Math.max(max, sum + next);
				}
				if (j + 2 < C) {
					next = map[i][j + 1] + map[i][j + 2];
					max = Math.max(max, sum + next);
				}
				sum -= map[i - 1][j];
			}
		}
	}

	static void trio() {
		int sum = 0;
		for (int i = 0; i < R - 2; i++) {//세로
			for (int j = 0; j < C; j++) {
				sum = map[i][j] + map[i + 1][j] + map[i + 2][j];
				if (j > 0) {
					for (int j2 = 0; j2 < 3; j2++) {
						max =Math.max(max, sum+map[i+j2][j-1]);
					}
				}
				if(j+1<C) {
					for (int j2 = 0; j2 < 3; j2++) {
						max =Math.max(max, sum+map[i+j2][j+1]);
					}
				}
			}
		}
		for (int j = 0; j < C-2; j++) {
			for (int i = 0; i < R; i++) {
				sum= map[i][j]+map[i][j+1]+map[i][j+2];
				if(i>0) {
					for (int k = 0; k <3; k++) {
						max=Math.max(max, sum+map[i-1][j+k]);
					}
				}
				if(i+1<R) {
					for (int k = 0; k <3; k++) {
						max=Math.max(max, sum+map[i+1][j+k]);
					}
				}
			}
		}
	}
}
