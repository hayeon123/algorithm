import java.util.Arrays;
import java.util.Scanner;

public class n과m7 {
	static int N, M;
	static int[] arr; 
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt(); 
		M = sc.nextInt(); 
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]= sc.nextInt();
		}
		sb = new StringBuilder();
		Arrays.sort(arr);
		comb(0, new int[M]);
		System.out.println(sb);
	}
	static void comb(int idx, int[] select) {
		if(idx== select.length) {
			for (int i = 0; i < select.length; i++) {
				sb.append(select[i]).append(" ");
			}sb.append('\n');
			return; 
		}
		for (int i = 0; i < arr.length; i++) {
			select[idx]= arr[i];
			comb(idx+1, select);
		}
	}
}
