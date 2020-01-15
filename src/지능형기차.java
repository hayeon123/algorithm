import java.util.Scanner;

public class 지능형기차 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max =0; 
		int arr[][] = new int[5][2];//out in 
		int status[] = new int[5]; 
		for (int i = 1; i < 5; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			status[i]= status[i-1]-arr[i][0]+arr[i][1];
		}
	
		for (int i = 1; i < 5; i++) {
			max = Math.max(status[i], max);
//			System.out.println(status[i]);
		}
		System.out.println(max);
	}

}
