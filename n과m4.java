import java.util.Scanner;

public class n과m4 {
	static int N,M;
	static StringBuilder sb; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt(); 
		
		sb = new StringBuilder();
		comb(0, new int[M],1);
		
		System.out.println(sb);
		
		
	}
	static void comb(int idx, int[] select, int k) {
		if(idx==select.length) {
			for (int i = 0; i < select.length; i++) {
				sb.append(select[i]).append(" ");
			}sb.append('\n');
			return;
		}
		if(k>N)return;
		select[idx]= k; 
		comb(idx+1, select, k); 
		comb(idx, select, k+1);
	}
}
