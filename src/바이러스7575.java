import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스7575 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][];
		for (int i = 0; i < N; i++) {
			int m = Integer.parseInt(br.readLine());
			arr[i] = new int[m];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int start = 0;
		int end = K;

		out3: for (int i = 0; i <= arr[0].length - K; i++) {
			start = i;
			end = K + i;
			boolean check =true; 
			out2: for (int j = 1; j < arr.length; j++) {// 나머지 행들의 수 중에서
				boolean flag = false; 
				out1: for (int j2 = 0; j2 <= arr[j].length - K; j2++) {
					int next_start = j2;
					int next_end = j2 + K - 1;
					boolean lr_check = true;//왼쪽에서 오른쪽 
					boolean rl_check = true;//반대방향 
					for (int l = 0; l < K; l++) {
//						System.out.println(arr[0][start + l] +" "+ arr[j][next_end - l]);
						if (lr_check && arr[0][start + l] != arr[j][next_start + l]) {
							lr_check= false; 
						}
						if (rl_check && arr[0][start + l] != arr[j][next_end - l]) {
//							System.out.println(arr[0][start + l] +" "+ arr[j][next_end - l]);
							rl_check= false;
						}
						if(!lr_check && !rl_check)break;
					}
					if(lr_check || rl_check) {
						flag = true; 
						break out1; 
					}
				}
				if(!flag) {
					check = false; 
					break out2;
				}
			}//out2
			if(check) {
				System.out.println("YES");
				return;
			}
		}//out3
		System.out.println("NO");
	}
}
