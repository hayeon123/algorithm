package algorithm;

import java.util.Scanner;

public class º®µ¹±ú±â {
	static int N, C, R; 
	static int[][] map; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 
		for(int tc =1; tc<=T ; tc++) {
			int result =0; 
			N = sc.nextInt(); 
			C = sc.nextInt(); 
			R = sc.nextInt(); 
			map= new int[R][C]; 
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = sc.nextInt(); 
				}
			}
			
			
			
			System.out.println("#"+tc+" "+result);
		}
	}
}
