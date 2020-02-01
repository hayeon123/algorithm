import java.util.Arrays;
import java.util.Scanner;

public class 방번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char str[] = sc.next().toCharArray();
		int set =1; 
		int num[] = new int[9];
		Arrays.fill(num, 1);
		num[6]++;
		for (int i = 0; i < str.length; i++) {
			if(str[i]=='9')str[i]='6';
			
			int n = str[i]-'0';
			if(num[n]==0) {
				set++;
				for (int j = 0; j < num.length; j++) {
					num[j]++;
				}num[6]++;
				num[n]--;
			}else {
				num[n]--;
			}
		}
		System.out.println(set);
	}
}
