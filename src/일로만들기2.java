import java.util.Arrays;
import java.util.Scanner;

public class 일로만들기2 {
	static int min = 987654321;
	static String result = "";
	static int visited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		result += N;
		visited = new int[N + 1];
		visited[N] = 0;
		Arrays.fill(visited, 987654321);
		int[] list = new int[N]; 
		list[0]=N;
		solution(0, N, list, 1);
		System.out.println(min);
		System.out.println(result);
	}

	static void solution(int cnt, int num, int[] list, int idx) {
		if (num == 1) {
			if (min > cnt) {
				StringBuilder sb = new StringBuilder(); 
				for (int i = 0; i <= cnt; i++) {
					sb.append(list[i]).append(" ");
				}
				result = sb.toString();
				min = cnt;
			}
			return;
		}
		int k = 0;
		
		if (num % 3 == 0) {
			k = num / 3;
			if (cnt + 1 < visited[k]) {
				list[idx]=k;
				solution(cnt + 1, (num / 3),list, idx+1 );
				visited[k] = cnt + 1;
			}
		}
		if (num % 2 == 0) {
			k = num / 2;
			if (cnt + 1 < visited[k]) {
				list[idx]=k;
				solution(cnt + 1, (num / 2),list, idx+1 );
				visited[k]=cnt+1;
			}
		}
		if (cnt + 1 < visited[num - 1]) {
			list[idx]=num-1;
			solution(cnt + 1, num - 1,list, idx+1 );
			visited[num-1]=cnt+1;
		}

	}
}
