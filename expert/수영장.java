package expert;

import java.util.Scanner;

public class 수영장 {
	static int min =987654321;
	static int[] tax;
	static int[] month;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int T =sc.nextInt(); 
		for(int tc =1; tc<=T; tc++) {
			tax=new int[4];
			month = new int[12];
			for (int i = 0; i < tax.length; i++) {
				tax[i]=sc.nextInt();
			}
			for (int i = 0; i < month.length; i++) {
				month[i]=sc.nextInt();
			}
			min = tax[3];
			solution(0,0);
			System.out.println("#"+tc+" "+min);
		}
	}
	static void solution(int cnt,int m) {
		if(m>=12) {
			min = Math.min(min, cnt);
			return;
		}
		if(month[m]>0) {
			solution(cnt+(month[m]*tax[0]),m+1);//1일 이용권 
			solution(cnt+(tax[1]),m+1);//1달 이용권
			solution(cnt+(tax[2]),m+3);//3달 이용권 
		}
		else {
			solution(cnt,m+1);
		}
	}
}
