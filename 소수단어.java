
import java.util.Scanner;

public class 소수단어 {
	public static void main(String[] args) {

		boolean arr[] = new boolean[1042];
		
		for(int i =2; i*i<arr.length; i++) {
			for(int j = i*i; j<arr.length; j+=i) {
				arr[j]=true;
			}
		}
		
		Scanner sc = new Scanner(System.in);
		char[] prime = sc.next().toCharArray();
		int num =0;
		for(char c : prime) {
			if(c>=97) {
				num+= c-96;
			}else {
				num+= c-65+27;
			}
		}
		if(arr[num]) {
			System.out.println("It is not a prime word.");
		}else {
			System.out.println("It is a prime word.");
		}
		
	}
}
