package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최적경로 {
	static int answer;
	static int N; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			answer =987654321; 
			 N = Integer.parseInt(br.readLine());
		
			int[] x = new int[N+2];
			int[] y = new int[N+2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N+2; i++) {
				x[i]= Integer.parseInt(st.nextToken()); 
				y[i]= Integer.parseInt(st.nextToken());
			}
			permutation(x,y, 0,0,0,0);
			
			System.out.println("#"+tc+" "+answer);
		}
	}
	static void permutation(int[] x, int[] y, int visited, int sum, int idx,int cnt) {
		if(sum>=answer)return;
		if(cnt== N) {
			sum+=Math.abs(x[1]-x[idx])+Math.abs(y[1]-y[idx]);
			if(sum<answer)answer = sum;
			return;
		}
		for (int i = 2; i < y.length; i++) {
			if((visited & 1<<i)==0) {
				int tmp = Math.abs(x[idx]-x[i])+Math.abs(y[idx]-y[i]);
				permutation(x, y, (visited|(1<<i)), sum+tmp, i,cnt+1);
			}
		}
	}
}
