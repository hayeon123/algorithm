package expert;

import java.util.Scanner;

public class 달팽이숫자 {
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int T = sc.nextInt(); 
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); 
			int map[][] = new int[N][N];
			int num = 1; 
			int r = 0; 
			int c = 0;
			
			int dir = 0; 
			while(num <=N*N) {
				map[r][c]=num++; 
				int nr = r+dr[dir];
				int nc = c+dc[dir];
				if(!check(nr,nc,N)||map[nr][nc]!=0) {
					dir++; 
					if(dir>3)dir=0;
					nr = r+dr[dir]; 
					nc = c+dc[dir];
				}
				r= nr; 
				c= nc;
				
			}
			System.out.println("#"+tc);
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.print(map[i][j]+" ");
				}System.out.println();
			}
		}
		
	}
	static boolean check(int r, int c, int N) {
		return r>=0 && c>=0 && r<N && c<N;
	}
	
}
