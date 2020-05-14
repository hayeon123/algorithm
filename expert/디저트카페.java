package expert;

import java.util.ArrayList;
import java.util.Scanner;

public class 디저트카페 {
	static int[] dr = {1,1,-1,-1}; 
	static int[] dc = {1,-1,-1,1};
	static int[][] map ;
	static int N; 
	static int max; 
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); 
		int T = s.nextInt(); 
		for(int tc=1; tc<=T; tc++) {
			
			max =0; 
			N = s.nextInt(); 
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] =s.nextInt();
				}
			}
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					solution(i,j,new ArrayList<Integer>(), i,j, 0);
				}
			}
			if(max==0)System.out.println("#"+tc+" -1");
			else
			System.out.println("#"+tc+" "+max);
		}
		
	}
	static void solution(int sr, int sc, ArrayList<Integer> list, int r, int c, int dir) {
		if(dir==3 &&  r== sr && c==sc) {
//			System.out.println(list.size());
			if(list.size()>1) {
				max =Math.max(max, list.size());
			}
			return ;
		}
		int nr = r+dr[dir];
		int nc = c+dc[dir];
		if(check(nr,nc)&& !list.contains(map[nr][nc])) {
//			System.out.println(map[nr][nc]);
			list.add(map[nr][nc]);
			solution(sr,sc,list,nr,nc,dir);
			list.remove(list.size()-1);
		}
		if(dir<3) {
			nr = r+dr[dir+1]; 
			nc = c+dc[dir+1];
			if(check(nr,nc)&& !list.contains(map[nr][nc])) {
				list.add(map[nr][nc]);
				solution(sr,sc,list,nr,nc,dir+1);
				list.remove(list.size()-1);
			}
		}
	}
	
	static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
}
