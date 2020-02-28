package expert;

import java.util.Scanner;

public class 퀴즈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 
		long[] arr = new long[100000001];
		for (int i = 1; i < arr.length; i++) {
			long a = i%1000000007;
			arr[i]=(a*a)%1000000007+arr[i-1]%1000000007;
//			System.out.println(arr[i]);
		}
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt(); 
			
			System.out.println("#"+tc+" "+arr[N]);
		}
	}
}
