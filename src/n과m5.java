import java.util.Arrays;
import java.util.Scanner;

public class n과m5 {
	static int N,M;
	static int[] arr ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt(); 
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]= sc.nextInt();
		}
		Arrays.sort(arr);
		perm(0, new int[M], new boolean[N]);
	}
	static void perm(int idx, int[] select, boolean[] visited) {
		
		if(idx == select.length) {
			for (int i = 0; i < select.length; i++) {
				System.out.print(select[i]+" ");
			}System.out.println();
			return; 
		}
		for (int i = 0; i < arr.length; i++) {
			if(visited[i])continue; 
			select[idx]= arr[i]; 
			visited[i]= true;
			perm(idx+1, select, visited);
//			visited[i]= false;
			
		}
		
	}
	
}
