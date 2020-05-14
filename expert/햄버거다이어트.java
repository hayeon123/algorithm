package expert;

import java.util.Scanner;

public class 햄버거다이어트 {
	static int N ; 
	static int L;
	static int max;
	static Burger bur[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int T = sc.nextInt(); 
		for(int tc =1; tc<=T; tc++) {
			 N = sc.nextInt(); 
			 L = sc.nextInt(); 
			 bur = new Burger[N];
			 for (int i = 0; i <N; i++) {
				bur[i]= new Burger(sc.nextInt(), sc.nextInt());
			}
			max = 0; 
			solution(0,0,0);
			
			System.out.println("#"+tc+" "+max);
		}
	}
	static class Burger{
		int cal; 
		int score; 
		Burger(int score, int cal){
			this.score =score; 
			this.cal = cal;
		}
	}
	static void solution(int idx, int cal, int score) {
		if(idx==N) {
			return;
		}
		
		if(cal+bur[idx].cal<=L) {
			solution(idx+1, cal+bur[idx].cal, score+bur[idx].score);
			max = Math.max(max, score+bur[idx].score);
		}
		solution(idx+1, cal, score);
		
	}
}
