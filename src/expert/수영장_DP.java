package expert;

import java.util.Arrays;
import java.util.Scanner;

public class 수영장_DP {
	static int min =987654321;
	static int[] tax;
	static int[] month;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int T =sc.nextInt(); 
		for(int tc =1; tc<=T; tc++) {
			tax=new int[4];
			month = new int[12];
			for (int i = 0; i < tax.length; i++) {
				tax[i]=sc.nextInt();
			}
			for (int i = 0; i < month.length; i++) {
				month[i]=sc.nextInt();
			}
			min = tax[3];
			int[] memo =new int[12];
			memo[0]=Math.min(month[0]*tax[0],tax[1]);
			memo[1]=memo[0]+Math.min(month[1]*tax[0],tax[1]);
			memo[2]=Math.min(tax[2],memo[1]+ Math.min(month[2]*tax[0], tax[1]));
			
			for (int i = 3; i < memo.length; i++) {
				memo[i]=Math.min(memo[i-3]+tax[2], memo[i-1]+Math.min(month[i]*tax[0], tax[1]));
			}
			
			min = Math.min(min, memo[11]);
			System.out.println("#"+tc+" "+min);
		}
	}
}
