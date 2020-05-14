package expert;

import java.util.Scanner;

public class 부분수열의합 {
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int K = sc.nextInt();
			int arr[] = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			cnt = 0;
			comb(0, N, 0, arr, 0, K);
			System.out.println("#" + tc + " " + cnt);
		}
	}

	public static void comb(int idx, int j, int a_idx, int arr[], int sum, int K) {
		if (idx == j||a_idx == arr.length) {
			return;
		}
		
		if (sum + arr[a_idx] >= K) {
			if(sum+arr[a_idx]==K)
			cnt++;
			comb(idx, j, a_idx + 1, arr, sum, K);
		} else if (sum + arr[a_idx] < K) {
			comb(idx, j, a_idx + 1, arr, sum, K);
			comb(idx + 1, j, a_idx + 1, arr, sum + arr[a_idx], K);

		}

	}
}
