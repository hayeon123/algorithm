import java.util.Scanner;

public class 모든순열 {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		perm(0, new int[N], new boolean[N+1]);
	}

	static void perm(int idx, int[] select, boolean[] visited) {
		if (idx == select.length) {
			for (int i = 0; i < select.length; i++) {
				System.out.print(select[i] + " ");
			}
			System.out.println();
			return;
		}
//		if(k>N)return;
		for (int i = 1; i <= N; i++) {
			if (visited[i])// {
				continue;
//			}else {
			select[idx] = i;
			visited[i] = true;
			perm(idx + 1, select, visited);
			visited[i] =false;
//			}
		}

	}
}
