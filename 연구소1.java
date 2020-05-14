import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소1 {
	static int R, C;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int[][] map;
	static int result; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt(); 
		C = sc.nextInt(); 
		map =new int[R][C];
		result = 0; 
		Queue<Virus> virus = new LinkedList<>();
		int cnt = R*C; 
		for(int i =0; i<R; i++) {
			for(int j =0; j<C; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==2) {
					virus.add(new Virus(i,j)); 
					cnt--; 
					
				}else if(map[i][j]==1) {
					cnt--;
				}
			}
		}
		
		boolean visited[][]= new boolean[R][C];
		for(int i =0; i<R; i++) {
			for(int j =0; j<C; j++) {
				if(map[i][j]==2||map[i][j]==1)continue;
				visited[i][j]=true; 
				
				for(int i1=0; i1<R; i1++) {
					for(int j1=0; j1<C; j1++) {
						if(map[i1][j1]==2||map[i1][j1]==1)continue;
						if(visited[i1][j1])continue;
						visited[i1][j1]=true; 
						
						for(int i2=0; i2<R; i2++) {
							for(int j2=0; j2<C; j2++) {
								if(map[i2][j2]==1||map[i2][j2]==2)continue;
								
								if(visited[i2][j2])continue;
								
								visited[i2][j2]=true; 
								Queue<Virus> que = new LinkedList<>();
								que.addAll(virus);
								solution(que, visited, cnt-3);
								visited[i2][j2]=false;
							}
						}
						visited[i1][j1]=false;
					}
				}
				visited[i][j]=false;
			}
		}
		System.out.println(result);
	}
	public static void solution(Queue<Virus> que, boolean visited[][], int cnt ) {
		
		while(!que.isEmpty()) {
			Virus virus = que.poll(); 
			for(int d = 0; d<4; d++) {
				int nr= virus.r+dr[d];
				int nc = virus.c+dc[d];
				if(!check(nr,nc)||visited[nr][nc]||map[nr][nc]==1||map[nr][nc]==2)continue;
				visited[nr][nc]=true; 
				que.add(new Virus(nr,nc));
				cnt--;
				if(cnt<result)return;
			}
		
		}
		result=Math.max(result, cnt);
		
	}
	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	static class Virus {
		int r, c;

		Virus(int r, int c) {
			this.r = r;
			this.c = c;

		}
	}

}
