import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자정사각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i]=br.readLine().toCharArray();
		}
		int max =0; 
		int len = Math.min(N, M)-1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = len; k >=0; k--) {
					if(i+k>=N||j+k>=M)continue; 
					if(map[i][j]==map[i+k][j]&& map[i][j]==map[i][j+k]&& map[i][j]==map[i+k][j+k]) {
						max =Math.max(max, (k+1)*(k+1));
					}
				}
			}
		}
		System.out.println(max);
	}
}
