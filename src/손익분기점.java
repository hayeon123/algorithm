import java.util.Scanner;

public class 손익분기점 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in); 
		int A = sc.nextInt();//고정비용 
		int B = sc.nextInt(); //노트북생산비용  
		int C = sc.nextInt(); //노트북가격 
		
		if(C<=B) {
			System.out.println(-1);
			return;
		}
		
		int result =(A/(C-B))+1;
		System.out.println(result);
	}
}
