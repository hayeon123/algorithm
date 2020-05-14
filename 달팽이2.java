import java.util.Scanner;

public class 달팽이2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int N = sc.nextInt(); 
		int M = sc.nextInt(); 
		int[][] map = new int[N][M];
		int[] dr = {0,1,0,-1}; 
		int[] dc = {1,0,-1,0}; 
		int cnt =0; 
		int dir =0; 
		int r = 0; 
		int c =0; 
		map[r][c]=1;
		int k = N*M-1; 
		while(true) {
			if(k==0)break;
			int nr = r+dr[dir]; 
			int nc = c+dc[dir];
			if(nr<0 || nc<0 || nr>=N ||nc>=M||map[nr][nc]!=0){
				cnt++; 
				dir++; 
				if(dir==4)dir=0; 
			}else {
				r= nr; 
				c = nc; 
				map[r][c]=1; 
				k--; 
			}
		}
		System.out.println(cnt);
	}
}
