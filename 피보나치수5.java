import java.util.Arrays;
import java.util.Scanner;

public class 피보나치수5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		int[]arr = new int[21]; 
		arr[1]=1; 
		fibonacci(n, arr, 2);
	}
	static void fibonacci(int n,int arr[], int k) {
		if(k > n) {
			System.out.println(arr[n]);
			return;
		}
		if(n==0 || n==1) {
			System.out.println(arr[n]);
			return;
		}
		arr[k]=arr[k-1]+arr[k-2];
		fibonacci(n, arr, k+1);
	}
}
