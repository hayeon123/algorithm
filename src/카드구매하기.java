package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드구매하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] card = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < card.length; i++) {
			card[i]=Integer.parseInt(st.nextToken());
		}
	
		for (int i = 2; i < card.length; i++) {
			for (int j = 1; j <= i/2; j++) {
				card[i]=Math.max(card[i], card[i-j]+card[j]);
			}
		}

		System.out.println(card[N]);
	}

}
