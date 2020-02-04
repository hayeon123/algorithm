package expert;

import java.util.Scanner;

public class 초심자의_회문검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); 
		for(int tc =1; tc<=T; tc++) {
			char[] str = sc.next().toCharArray();
			boolean check = true;
			for (int i = 0; i < str.length/2; i++) {
				if(str[i]!=str[str.length-i-1]) {
					check = false; 
					break;
				}
			}
			if(check)System.out.println("#"+tc+" 1");
			else System.out.println("#"+tc+" 0");
			
		}
	}
}
