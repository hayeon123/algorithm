import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 회전하는큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // ť�� ũ��
		int M = Integer.parseInt(st.nextToken()); // �̾Ƴ����� �ϴ� ���� ����
		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int size = N;
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				for (int j = i+1; j < arr.length; j++) {
					arr[j]--;
				}
				size--;
			}

			else if (arr[i] <= size - arr[i] + 1) {
				cnt += arr[i] - 1;
				for (int j = i + 1; j < arr.length; j++) {
					arr[j] -= arr[i];
					if (arr[j] <= 0) {
						arr[j] += size;
					}
				}
				size--;
			} else if (arr[i] > size - arr[i] + 1) {
				cnt += size - arr[i]+1;
				for (int j = i + 1; j < arr.length; j++) {
					arr[j] += size - arr[i];
					if (arr[j] > size) {
						arr[j] -= size;
					}
				}
				size--;
			}
		}

		System.out.println(cnt);
	}
}
