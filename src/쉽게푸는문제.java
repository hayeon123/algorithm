package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class ����Ǫ�¹��� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		int[] arr = new int[1001];
		int num = 1;
		int idx = 1;
		while (idx < arr.length) {
			for (int j = 0; idx < arr.length && j < num; j++) {
				arr[idx++] = num;
			}
			num++;
		}
		int ans =0; 
		for(int i = start; i<=end ; i++) {
			ans+=arr[i];
		}
		System.out.println(ans);
	}
}
