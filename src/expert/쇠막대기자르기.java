package expert;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int T = sc.nextInt(); 
		for(int tc=1; tc<=T; tc++) {
			char[] arr = sc.next().toCharArray(); 
			Stack<Character> stack = new Stack<Character>(); 
			char tmp = arr[0];
			int cnt = 0; 
			for (int i = 1; i < arr.length; i++) {
				if(tmp == '(' && arr[i]==')') {//레이져 
					cnt += stack.size();
					
				}else if(tmp =='('&&arr[i]=='(') {
					stack.push('(');
				}else if(tmp == ')'&& arr[i]== ')') {
					cnt++; 
					stack.pop();
				}else if(tmp ==')' && arr[i]== '(') {
					
				}
				tmp = arr[i]; 
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
