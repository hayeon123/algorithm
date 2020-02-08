package expert;

import java.util.Scanner;
import java.util.Stack;

public class 괄호짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		out : for (int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt(); 
			char[] arr = sc.next().toCharArray(); 
			Stack<Character> stack = new Stack<>();
			
			for (int i = 0; i < len; i++) {
				if(arr[i]=='('||arr[i]=='['||arr[i]=='{'||arr[i]=='<') {
					stack.push(arr[i]);
				}else {
					switch (arr[i]) {
					case ')':
						if(stack.peek()=='(')stack.pop();
						else {
							System.out.println("#"+tc+" 0");
							continue out ;
						}
						break;
					case ']':
						if(stack.peek()=='[')stack.pop();
						else {
							System.out.println("#"+tc+" 0");
							continue out ;
						}
						break;
					case '}':
						if(stack.peek()=='{')stack.pop();
						else {
							System.out.println("#"+tc+" 0");
							continue out ;
						}
						break;
						
					case '>':
						if(stack.peek()=='<')stack.pop();
						else {
							System.out.println("#"+tc+" 0");
							continue out ;
						}
						break;
					
					default:
						break;
					}
				}
			}
			
			if(stack.size()>0)System.out.println("#"+tc+" 0");
			else System.out.println("#"+tc+" 1");
		}
	}
}
