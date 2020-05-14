import java.util.Scanner;

public class 한수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;
		
		if (N < 100) {
			answer = N;
		} else {
			answer+=99;
			for(int i =100; i<=N; i++) {
				int a = i/100; 
				int b = (i%100)/10; 
				int c = i%10; 
				if(a-b==b-c)answer++;
				
			}
		}
		System.out.println(answer);
	}
}
