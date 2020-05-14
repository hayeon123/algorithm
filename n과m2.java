import java.util.Scanner;

public class n과m2 {
	static int N; 
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//1부터 n까지
		M = sc.nextInt(); //m개 고른것 
		comb(0, new int[M], 1);
	}
	static void comb(int idx, int[] select, int k) {
		if(idx == select.length) {
			for (int i = 0; i < select.length; i++) {
				System.out.print(select[i]+" ");
			}System.out.println();
			return;
		}
		if(k>N) {
			return;
		}
		select[idx] = k; 
		comb(idx+1, select, k+1);
		comb(idx, select, k+1);
	}
}
