package expert;

import java.util.Arrays;
import java.util.Scanner;

public class 규영이와_인영이의_카드게임 {
	
	static int win; 
	static int lose;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
		
			win = 0; 
			lose =0; 
			int[] ku = new int[9]; 
			int[] in = new int[9];
			boolean[] check = new boolean[19];
			for (int i = 0; i < 9; i++) {
				ku[i]=sc.nextInt();
				check[ku[i]]=true;
			}
			int idx =0 ;
			for (int i = 1; i < check.length; i++) {
				if(!check[i]) {
					in[idx]=i; 
					idx++;
				}
			}
			perm(ku, in, 0,  new boolean[9],0,0);
			System.out.println("#"+tc+" "+win+" "+lose);
		}

	}
	static void perm(int[] ku, int[] in,int idx,boolean[] visited, int k, int iny) {
		if(idx==9) {
			if(k>iny)win++; 
			else lose++;
			return;
		}
		for (int i = 0; i < 9; i++) {
			if(visited[i])continue;
			visited[i]=true; 
			if(ku[idx]>in[i]) {
				perm(ku, in,idx+1,visited, k+ku[idx]+in[i], iny);
			}else if(ku[idx]<in[i]) {
				perm(ku, in,idx+1, visited, k, iny+ku[idx]+in[i]);
			}
			visited[i]=false;
		}
	}
}
