package algorithm;

import java.util.Scanner;

public class ¸®¸ðÄÁ {
	static boolean button[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int N = sc.nextInt(); 
		int M = sc.nextInt(); 
		button = new boolean[12];// 10=+, 11=-
		for(int i =0; i<M;i++) {
			button[sc.nextInt()]= true;
		}
		int channel = 100; 
		if(channel == N ) {
			System.out.println(0);
			return ; 
		}
		
		int min = Math.abs(N-100);
		
		int up = N; 
		int down = N;
		int cnt =(N+"").length(); 
		while(!isPossible(up)&&!isPossible(down)) {
			up++; 
			if(down>0)
			down--; 
			cnt++;
		}
		min = Math.min(cnt, min);
		System.out.println(min);
	}
	static boolean isPossible(int channel) {
		String st = channel+"";
		char[] num = st.toCharArray();
		for(char n : num) {
			if(button[n-48]) {
				return false;
			}
		}
		return true;
	}
}
