import java.util.Scanner;

public class 퇴사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		int[][] memo= new int[n+1][n+1];
		int[][] table = new int[n+1][2]; 
		for (int i = 1; i < table.length; i++) {
			table[i][0]=sc.nextInt(); 
			table[i][1]=sc.nextInt(); 
		}
		int answer =0; 
		for (int i = 1; i < table.length; i++) {
			if(table[i][0]+i-1>n)continue; 
			int max =0; 
			for (int j = 1; j < memo.length; j++) {
				if(memo[j][i]==0) {
					int idx =i-1; 
					int tmp=0;
					while(idx>0) {
						if(memo[j][idx]!=0) {
							tmp = memo[j][idx];
							break;
						}
						idx--; 
					}
					max =Math.max(max, tmp);
				}
			}
			max+=table[i][1];
			for (int j = 0; j < table[i][0]; j++) {
				memo[i][i+j]=max; 
			}
			answer =Math.max(max, answer);
		}
		System.out.println(answer);
	}
}
