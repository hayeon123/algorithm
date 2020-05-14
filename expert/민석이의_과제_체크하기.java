package expert;

import java.util.Scanner;

public class 민석이의_과제_체크하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 
		for (int tc = 1; tc <=T; tc++) {
			int N = sc.nextInt(); 
			int K = sc.nextInt();
			boolean[] arr = new boolean[N+1];
			for (int i = 0; i < K; i++) {
				arr[sc.nextInt()]=true;
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" " );
			for (int i = 1; i < arr.length; i++) {
				if(!arr[i])sb.append(i).append(" " );
			}
			System.out.println(sb);
		}
	}
}
