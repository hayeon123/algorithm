import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리조작 {
	static int R, C, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		boolean[][][] map = new boolean[C + 1][C + 1][R + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[b][b + 1][a] = true;
			map[b + 1][b][a] = true;
		}
		cnt = 987654321;
		if (sol(map)) {
			cnt =0; 
		} else {
			for (int i = 2; i <= C; i++) {
				for (int j = 1; j <= R; j++) {
					if(map[i][i-1][j])continue;
					map[i][i-1][j]=true; 
					map[i-1][i][j]=true; 
					if(sol(map)) {
						cnt =1; 
						break;
					}
					if (cnt > 2) {
						out2: for (int i2 = 2; i2 <= C; i2++) {
							for (int j2 = 1; j2 <= R; j2++) {
								if(map[i2][i2-1][j2])continue; 
								if(i== i2 && j== j2)continue; 
								map[i2][i2-1][j2]=true; 
								map[i2-1][i2][j2]=true; 
								if(sol(map)) {
									cnt =2; 
									map[i2][i2-1][j2]=false; 
									map[i2-1][i2][j2]=false; 
									break out2; 
								}
								if (cnt > 3) {
									out3: for (int i3 = 2; i3 <=C; i3++) {
										for (int j3 = 1; j3 <= R; j3++) {
											if(map[i3][i3-1][j3])continue; 
											if((i3==i&& j3==j)||(i3==i2&&j3==j2))continue; 
											map[i3][i3-1][j3]=true; 
											map[i3-1][i3][j3]=true; 
											if(sol(map)) {
												cnt = 3; 
												map[i3][i3-1][j3]=false; 
												map[i3-1][i3][j3]=false; 
												break out3; 
											}
											map[i3][i3-1][j3]=false; 
											map[i3-1][i3][j3]=false; 
											
										}
									}
								}
								map[i2][i2-1][j2]=false; 
								map[i2-1][i2][j2]=false; 
								
							}
						}
					
					}
					map[i][i-1][j]=false; 
					map[i-1][i][j]=false; 
					
				}
			}
		}
		if(cnt>3)System.out.println(-1);
		else System.out.println(cnt);
	}
	static int cnt;

	public static boolean sol(boolean[][][] map) {
		for (int i = 1; i <= C; i++) {
			int c = i;
			int h = 1;
			while (h <= R) {
				if (c == 1) {
					// 맨 왼쪽일 때
					if (map[c][c + 1][h]) {
						c++;
						h++;
					} else {
						h++;
					}
				} else if (c == C) {
					// 맨 오른쪽일 때
					if (map[c][c - 1][h]) {
						c--;
						h++;
					} else {
						h++;
					}

				} else {
					// 가운데일 때
					if (map[c][c - 1][h] && map[c][c + 1][h]) {
						return false;
					} // 양쪽에 다 있는 경우 ㄴㄴ
					if (map[c][c - 1][h]) {
						c--;
						h++;
					} else if (map[c][c + 1][h]) {
						c++;
						h++;
					} else {
						h++;
					}

				}

			}
			if (c != i)
				return false;
		}
		
		return true;
	}
}
