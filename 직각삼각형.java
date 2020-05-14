import java.util.Scanner;

public class 직각삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a==0 || b ==0 ||c ==0)break; 
			int max = Math.max(a, b);
			max = Math.max(max, c);
			int sum = a*a + b*b + c*c; 
			max*=max; 
			if(sum-max == max) {
				System.out.println("right");
			}else {
				System.out.println("wrong");
			}
		}
	}
}
