package expert;

import java.util.Arrays;
import java.util.Scanner;

public class 삼으로나눈_순열 {
	static int N; 
	static int arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); 
			arr = new int[N];
			int map[][] = new int [3][3];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				arr[i]=(sc.nextInt()%3);
				map[(i+1)%3][arr[i]]++;
				if((i+1)%3!=arr[i])cnt++;
			}
			int result =0;

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(i==j)continue; 
					
					if(map[i][j]>0&& map[j][i]>0) {
						if(map[j][i]>=map[i][j]) {
							map[j][i]-=map[i][j];
							cnt-=(map[i][j])*2;
							result +=map[i][j];
							map[i][j]=0; 
						}else {
							map[i][j]-=map[j][i];
							cnt-=(map[j][i])*2;
							result+= map[j][i];
							map[j][i]=0;
						}
					}
					
				}
			}
			if(cnt>0) {
				result+=(cnt/3)*2;
			}
			System.out.println("#"+tc+" "+result);
		}
	}
}
