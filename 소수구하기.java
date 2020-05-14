import java.util.Scanner;

public class 소수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		boolean[] arr = new boolean[N+1];
		
		for(int i =2; i*i<=N; i++) {
			for(int j = i*i; j<=N; j+=i) {
				arr[j]= true; 
			}
		}
		arr[1]= true;
		for(int i = M; i<=N; i++) {
			if(!arr[i])System.out.println(i);
		}
	}
}
