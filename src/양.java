import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 양 {
	static int R, C;
	static char[][] map;
	static int dr[]= {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int sheep,wolf;
	static boolean visited[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt(); 
		C = sc.nextInt(); 
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			map[i]=str.toCharArray();
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(visited[i][j]||map[i][j]=='#')continue;
				count(i,j);
			}
		}
		System.out.println(sheep+" "+wolf);
		
	}
	static void count(int r, int c) {
		int s=0;
		int w =0;
		
		Queue<Pos> que = new LinkedList<>();
		que.add(new Pos(r,c));
		if(map[r][c]=='v') {
			w++;
		}else if(map[r][c]=='o') {
			s++;
		}
		visited[r][c]= true;
		while(!que.isEmpty()) {
			Pos p = que.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r+dr[i];
				int nc = p.c+dc[i];
				if(!check(nr,nc)||visited[nr][nc]||map[nr][nc]=='#')continue;
				if(map[nr][nc]== 'v'){
					w++;
				}else if(map[nr][nc]=='o') {
					s++;
				}
				visited[nr][nc]=true; 
				que.add(new Pos(nr,nc));
			}
			
		}
		

		if(s>w) {
			sheep += s; 
		}else {
			wolf += w;
		}
		
	}
	static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<R && c<C;
	}
	static class Pos{
		int r, c; 
		Pos(int r, int c){
			this.r = r; 
			this.c = c;
		}
	}
}
