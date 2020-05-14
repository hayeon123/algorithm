
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스타트와링크 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = 987654321;
		recur(arr,0,0,0,new boolean[N], 0,0);
		System.out.println(answer);

	}

	static int N, answer;

	public static void recur(int[][] arr, int scnt, int lcnt, int idx, boolean[] check, int start, int link) {
		if (scnt > N / 2 || lcnt > N / 2) {
			return;
		}
		if (idx == check.length) {
			if (scnt == N / 2) {
				answer = Math.min(answer, Math.abs(start - link));
			}
			return;
		}
		int s_sum = 0;
		int l_sum = 0;
		for (int i = 0; i < idx; i++) {
			if(check[i]) {
				s_sum+=arr[i][idx];
				s_sum+=arr[idx][i];
			}else {
				l_sum+=arr[i][idx];
				l_sum+=arr[idx][i];
			}
		}
		check[idx]=true;
		recur(arr, scnt+1, lcnt, idx+1,check, start+s_sum, link);
		check[idx]=false;
		recur(arr, scnt, lcnt+1, idx+1, check, start, link+l_sum);

	}
}
