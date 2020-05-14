package expert;

import java.util.Scanner;

public class 등산로조성 {
	static int N;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1}; 
	static int map[][];
	static int max_len;
	static int K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 
		for(int tc=1; tc<=T; tc++) {
			 N = sc.nextInt(); 
			 K = sc.nextInt(); 
			 max_len=0;
			 map = new int[N][N];
			 int max=0;
			 for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=sc.nextInt();
					max = Math.max(map[i][j], max);
				}
			}
			 boolean visited[][];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==max) {
						visited= new boolean[N][N];
						visited[i][j]=true;
						solution(i,j,map[i][j],1, false, visited);
					}
				}
			}
			System.out.println("#"+tc+" "+max_len);
			
		}
	}
	static void solution(int r, int c, int num , int cnt, boolean check ,boolean visited[][] ) {
		for (int dir = 0; dir < 4; dir++) {
			int nr = r+dr[dir]; 
			int nc = c+dc[dir];
			if(!check(nr,nc)||visited[nr][nc]) continue; 
			if(map[nr][nc]>=num && !check) {
				if(map[nr][nc]-num<K) {
					visited[nr][nc]=true; 
					solution(nr,nc, num-1, cnt+1, true, visited);
					visited[nr][nc]=false;
				}
			}else if(map[nr][nc]<num){
				visited[nr][nc]=true; 
				solution(nr,nc, map[nr][nc],cnt+1, check, visited);
				visited[nr][nc]=false;
			}
		}
		max_len =Math.max(max_len, cnt);
		
	}
	static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
}
