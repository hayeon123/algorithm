package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class °æ»ç·Î {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		for (int i = 0; i < arr.length; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < arr.length; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0; 
		
		for (int i = 0; i < arr.length; i++) {
			int first = arr[i][0];
			boolean[] check = new boolean[N];
			int j =1; 
			boolean flag = true;
			out : while(j<arr.length) {
				if(first== arr[i][j]) {
					j++; 
					continue;
				}else if(first>arr[i][j]) {
					if(first-arr[i][j]>1||j+L-1>=arr.length) {
						flag = false;
						break out; 
					}
					int k = 0 ; 
					first = arr[i][j];
					while(k<L) {
						if(first==arr[i][j]) {
							check[j]=true;
							j++; 
							k++;
						}else {
							flag = false; 
							break out; 
						}
					}
				}else if(first<arr[i][j]) {
					if(arr[i][j]-first>1||j-L<0) {
						flag = false; 
						break out; 
					}
					int idx = j-L; 
					while(idx<j) {
						if(arr[i][idx]!=first||check[idx]) {
							flag = false; 
							break out ; 
						}
						check[idx]= true; 
						idx++; 
					}
					first = arr[i][j];
					j++;
				}
			}
			if(flag) {
				answer++; 
			}
		}

		for (int i = 0; i < arr.length; i++) {
			int first = arr[0][i];
			boolean[] check = new boolean[N];
			int j =1; 
			boolean flag = true;
			out : while(j<arr.length) {
				if(first== arr[j][i]) {
					j++; 
					continue;
				}else if(first>arr[j][i]) {
					if(first-arr[j][i]>1||j+L-1>=arr.length) {
						flag = false;
						break out; 
					}
					int k = 0 ; 
					first = arr[j][i];
					while(k<L) {
						if(first==arr[j][i]) {
							check[j]=true;
							j++; 
							k++;
						}else {
							flag = false; 
							break out; 
						}
					}
				}else if(first<arr[j][i]) {
					if(arr[j][i]-first>1||j-L<0) {
						flag = false; 
						break out; 
					}
					int idx = j-L; 
					while(idx<j) {
						if(arr[idx][i]!=first||check[idx]) {
							flag = false; 
							break out ; 
						}
						check[idx]= true; 
						idx++; 
					}
					first = arr[j][i];
					j++; 
				}
			}
			if(flag) {
				answer++; 
			}
		}
		
		System.out.println(answer);
		
		
		
		
	}
}
