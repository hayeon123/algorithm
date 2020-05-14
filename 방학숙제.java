import java.util.Scanner;

public class 방학숙제 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int L = sc.nextInt(); 
	int A = sc.nextInt(); //국어
	int B = sc.nextInt(); //수학
	
	int C = sc.nextInt(); //국어 
	int D = sc.nextInt(); // 수학
	
	int k = A/C; 
	if(A%C>0)k++; 
	int l = B/D; 
	if(B%D >0)l++; 
	System.out.println(L-Math.max(k, l));
}
}
