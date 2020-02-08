package expert;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int T = sc.nextInt(); 
		for(int tc=1; tc<=T; tc++) {
//			char[] arr = sc.next().toCharArray(); 
//			Stack<Character> stack = new Stack<Character>(); 
			String str = sc.next(); 
			
			int stack =0;
			char tmp = str.charAt(0);
			int cnt = 0; 
			for (int i = 1; i < str.length(); i++) {
				if(tmp == '(' && str.charAt(i)==')') {//레이져 
					cnt += stack;
					
				}else if(tmp =='('&&str.charAt(i)=='(') {
					stack++;
				}else if(tmp == ')'&&str.charAt(i)== ')') {
					cnt++; 
					stack--;
				}else if(tmp ==')' && str.charAt(i)== '(') {
					
				}
				tmp = str.charAt(i); 
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
