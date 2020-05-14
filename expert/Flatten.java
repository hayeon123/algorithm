package expert;

import java.util.Arrays;
import java.util.Scanner;

public class Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc =1; tc<=10 ; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[100];
			for (int i = 0; i < arr.length; i++) {
				arr[i]=sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				Arrays.sort(arr);
				arr[0]++; 
				arr[99]--; 
			}
			Arrays.sort(arr);
			System.out.println("#"+tc+" "+(arr[99]-arr[0]));
		}
	}
	

}
