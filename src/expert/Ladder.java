package expert;

import java.util.Scanner;

public class Ladder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dr = {-1, 0,0}; 
		int[] dc = {0, -1,1};
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			int map[][]= new int[100][100];
			int r = 0;
			int c = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 2) {
						r = i; 
						c = j; 
					}
				}
			}
			int dir = 0; 
			while(r>0) {
				int nr = r;
				int nc = c;
				//1
				if(dir == 0) {
					nr = r+dr[1]; 
					nc = c+dc[1];
					if(check(nr,nc)&&map[nr][nc]==1) {
						r= nr; 
						c = nc; 
						dir = 1; 
						continue; 
					}
					nr = r+dr[2]; 
					nc = c+dc[2]; 
					if(check(nr,nc)&&map[nr][nc]==1) {
						r= nr; 
						c = nc; 
						dir = 2; 
						continue; 
					}
					r = r+dr[0];
					c = c+dc[0];
					continue;
				}
				else if(dir ==1) {
					nr = r+dr[0]; 
					nc = c+dc[0];
					if(check(nr,nc)&&map[nr][nc]==1) {
						r= nr; 
						c = nc; 
						dir = 0; 
						continue; 
					}
					nr = r+dr[1]; 
					nc = c+dc[1];
					if(check(nr,nc)&&map[nr][nc]==1) {
						r= nr; 
						c = nc; 
						dir = 1; 
						continue; 
					}
				}
				//2
				else if(dir ==2) {
					nr = r+dr[0]; 
					nc = c+dc[0];
					if(check(nr,nc)&&map[nr][nc]==1) {
						r= nr; 
						c = nc; 
						dir = 0; 
						continue; 
					}
					nr = r+dr[2]; 
					nc = c+dc[2]; 
					if(check(nr,nc)&&map[nr][nc]==1) {
						r= nr; 
						c = nc; 
						dir = 2; 
						continue; 
					}
				}
				//0
				
			}
			
			System.out.println("#"+N+" "+c);
		}
		
	}
	static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<100 && c<100;
	}
}
