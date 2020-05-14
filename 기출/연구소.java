package 기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {
	static int R, C;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<Virus> list; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		list = new ArrayList<>();
		int cnt = 0; 
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					list.add(new Virus(i,j));
				}
				if(map[i][j]==0) {
					cnt++; 
				}
			}
		}
		int answer =0; 
		cnt-=3;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]!=0)continue; 
				for (int j2 = j+1; j2 < C; j2++) { //i줄에서 선택 
					if(map[i][j2]!=0)continue; 
					for (int j3 = j2+1; j3 < C; j3++) {//i번째 줄에서 선택 
						if(map[i][j3]!=0)continue;
						answer=Math.max(answer, check_safe(i,j,i,j2,i,j3,cnt));
					}
					for (int i3 = i+1; i3 < R; i3++) {//i 다음줄에서 세번째꺼 선
						for (int j3 = 0; j3 < C; j3++) {
							if(map[i3][j3]!=0)continue;
							answer=Math.max(answer, check_safe(i,j,i,j2,i3,j3,cnt));
						}
					}
				}
				for (int i2 = i+1; i2 < R; i2++) {
					for (int j2 = 0; j2 < C; j2++) {
						if(map[i2][j2]!=0)continue;
						for (int j3 = j2+1; j3 < C; j3++) {
							if(map[i2][j3]!=0)continue;
							answer = Math.max(answer, check_safe(i,j,i2,j2,i2,j3,cnt));
						}
						for (int i3 = i2+1; i3 < R; i3++) {
							for (int j3 = 0; j3 < C; j3++) {
								if(map[i3][j3]!=0)continue;
								answer =Math.max(answer, check_safe(i,j,i2,j2,i3,j3,cnt));
							}
						}
					}
					
				}
			}
		}
		System.out.println(answer);
	}
	static int check_safe(int i1,int j1, int i2, int j2, int i3, int j3, int cnt) {
		int[][] arr = new int[R][C]; 
		for (int i = 0; i < arr.length; i++) {
			System.arraycopy(map[i], 0, arr[i], 0, C);
		}
		arr[i1][j1]=1; 
		arr[i2][j2]=1; 
		arr[i3][j3]=1; 
		Queue<Virus> que = new LinkedList<>(); 
		for (int i = 0; i < list.size(); i++) {
			Virus v = list.get(i);
			que.add(new Virus(v.r,v.c));
		}
		while(!que.isEmpty()) {
			Virus v = que.poll(); 
			for (int dir = 0; dir < 4; dir++) {
				int nr = v.r+dr[dir];
				int nc = v.c+dc[dir];
				if(!check(nr,nc)||arr[nr][nc]!=0)continue; 
				arr[nr][nc]=2; 
				que.add(new Virus(nr,nc));
				cnt--; 
			}
		}
		return cnt; 
	}

	static class Virus {
		int r, c;
		Virus() {}
		Virus(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
