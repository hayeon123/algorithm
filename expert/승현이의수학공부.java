package expert;

import java.util.Scanner;

public class 승현이의수학공부 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 
		for(int tc =1; tc<=T; tc++) {
			int N = sc.nextInt(); 
			char[] num =sc.next().toCharArray();
			int sum =0; 
			for(int i =0; i<num.length;i++) {
				sum+=num[i]%(N-1);
			}
			int answer = sum%(N-1);
			
			System.out.println("#"+tc+" "+answer);
		}
	}
}
