import java.util.Scanner;

public class n과m3 {
	static int N;
	static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		comb(0, new int[M]);
	}
	static void comb(int idx, int[] select) {
		if(idx== select.length) {
			for (int i = 0; i < select.length; i++) {
				System.out.print(select[i]+" ");
			}System.out.println();
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			select[idx]= i; 
			comb(idx+1, select);
		}
	}

}