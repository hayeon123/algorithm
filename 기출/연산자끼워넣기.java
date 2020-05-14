package 기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int[] arr = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if (arr[0] > 0) {
			arr[0]--;
			add(num, 1, arr, num[0]);
			arr[0]++;
		}
		if (arr[1] > 0) {
			arr[1]--;
			minus(num, 1, arr, num[0]);
			arr[1]++;
		}
		if (arr[2] > 0) {
			arr[2]--;
			mul(num, 1, arr, num[0]);
			arr[2]++;
		}
		if (arr[3] > 0) {
			arr[3]--;
			div(num, 1, arr, num[0]);
			arr[3]++;
		}
		System.out.println(max);
		System.out.println(min);
	}

	public static void add(int[] num, int idx, int[] arr, int res) {
		if (idx == num.length-1) {
			res+=num[idx];
			min = Math.min(res, min);
			max = Math.max(res, max);
			return;
		}
		res += num[idx];
		if (arr[0] > 0) {
			arr[0] -= 1;
			add(num, idx + 1, arr, res);
			arr[0]++;
		}
		if (arr[1] > 0) {
			arr[1]--;
			minus(num, idx + 1, arr, res);
			arr[1]++;
		}
		if (arr[2] > 0) {
			arr[2]--;
			mul(num, idx + 1, arr, res);
			arr[2]++;
		}
		if (arr[3] > 0) {
			arr[3]--;
			div(num, idx + 1, arr, res);
			arr[3]++;
		}
		
	}

	public static void minus(int[] num, int idx, int[] arr, int res) {
		if (idx == num.length-1) {
			res-=num[idx];
			min = Math.min(res, min);
			max = Math.max(res, max);
			return;
		}
		res -= num[idx];
		boolean check =false; 
		if (arr[0] > 0) {
			arr[0] -= 1;
			add(num, idx + 1, arr, res);
			arr[0]++;
			check = true; 
		}
		if (arr[1] > 0) {
			arr[1]--;
			minus(num, idx + 1, arr, res);
			arr[1]++;
			check = true; 
		}
		if (arr[2] > 0) {
			arr[2]--;
			mul(num, idx + 1, arr, res);
			arr[2]++;
			check = true; 
		}
		if (arr[3] > 0) {
			arr[3]--;
			div(num, idx + 1, arr, res);
			arr[3]++;
			check = true; 
		}
		if(!check) {
			min = Math.min(res, min);
			max = Math.max(res, max);
		}
	}

	public static void mul(int[] num, int idx, int[] arr, int res) {
		if (idx == num.length-1) {
			res*=num[idx];
			min = Math.min(res, min);
			max = Math.max(res, max);
			return;
		}
		res *= num[idx];
		boolean check =false; 
		if (arr[0] > 0) {
			arr[0] -= 1;
			add(num, idx + 1, arr, res);
			arr[0]++;
			check = true; 
		}
		if (arr[1] > 0) {
			arr[1]--;
			minus(num, idx + 1, arr, res);
			arr[1]++;
			check = true; 
		}
		if (arr[2] > 0) {
			arr[2]--;
			mul(num, idx + 1, arr, res);
			arr[2]++;
			check = true; 
		}
		if (arr[3] > 0) {
			arr[3]--;
			div(num, idx + 1, arr, res);
			arr[3]++;
			check = true; 
		}
		if(!check) {
			min = Math.min(res, min);
			max = Math.max(res, max);
		}
	}

	public static void div(int[] num, int idx, int[] arr, int res) {
		if(num[idx]==0)return;
		if (idx == num.length-1) {
			if (res < 0) {
				res *= -1;
				res /= num[idx];
				res *= -1;
			} else {
				res /= num[idx];
			}
			min = Math.min(res, min);
			max = Math.max(res, max);
			return;
		}
		boolean check =false; 


		if (res <= 0) {
			res *= -1;
			res /= num[idx];
			res *= -1;
		} else {
			res /= num[idx];
		}
		if (arr[0] > 0) {
			arr[0] -= 1;
			add(num, idx + 1, arr, res);
			arr[0]++;
			check = true; 
		}
		if (arr[1] > 0) {
			arr[1]--;
			minus(num, idx + 1, arr, res);
			arr[1]++;
			check = true; 
		}
		if (arr[2] > 0) {
			arr[2]--;
			mul(num, idx + 1, arr, res);
			arr[2]++;
			check = true; 
		}
		if (arr[3] > 0) {
			arr[3]--;
			div(num, idx + 1, arr, res);
			arr[3]++;
			check = true; 
		}
		if(!check) {
			min = Math.min(res, min);
			max = Math.max(res, max);
		}

	}

}
