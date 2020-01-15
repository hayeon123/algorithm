import java.util.Arrays;
import java.util.Scanner;

public class n과m6{
	static int N,M;
	static int[] arr ;
	static StringBuilder sb ;
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
		perm(0, new int[M], 0);
		System.out.println(sb);
	}
	static void perm(int idx, int[] select, int k) {
		if(idx == select.length) {
			for (int i = 0; i < select.length; i++) {
				sb.append(select[i]).append(" ");
			}
			sb.append('\n');
			return; 
		}
		if(k>=N)return;
		select[idx]= arr[k]; 
		perm(idx+1, select, k+1);
		perm(idx, select, k+1);
	}
	
}
