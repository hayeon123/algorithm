

import java.util.Arrays;

public class 재귀 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };

//		recur(arr,0);
		boolean[] sel = new boolean[arr.length];
//		powerset(arr,sel,0);
//		combination(arr, new int[2], 0, 0);
//		comb(arr, new int[2], 0 , 0);
		comb(arr,new int[2],0, 0);
//		 permutation_re(arr, new int[2], 0);

//		permutation(arr, new int[2], 0, new boolean[arr.length]);
	}

	// arr의 idx번째를 sel의 k번째에 담고, 담은 것을 유효화하려면 Kㄴ를 늘려주고, 남은걸 무효화 하려면 k는 그대로 
	//[1, 2] [1, 3] [2, 3]

	static void combination(int[] arr, int[] sel, int idx, int k) {
		if (k == sel.length) {// 목적을 이룸, 다 고른 것
			System.out.println(Arrays.toString(sel));
			return;
		}
		if (idx == arr.length) {// 더이상 검사를 할게 없기 때문에 return,
			return;
		}

		sel[k] = arr[idx];
		
		combination(arr, sel, idx + 1, k + 1);
		combination(arr, sel, idx + 1, k);

	}
	//중복조합
	static void comb(int[] arr, int[] sel, int idx, int k) {
		if (k == sel.length) {// 목적을 이룸, 다 고른 것
			System.out.println(Arrays.toString(sel));
			return;
		}
		if (idx == arr.length) {// 더이상 검사를 할게 없기 때문에 return,
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			sel[k]= arr[i];
			comb(arr, sel, i, k+1);
			
		}
//		
//		sel[k] = arr[idx];
//		comb(arr, sel, idx, k + 1 );
//		comb(arr, sel, idx+1, k);
//	

	}

	// 중복순열을 뽑도록 코드 변경 [1, 1][1, 2][1, 3][2, 1][2, 2][2, 3][3, 1][3, 2][3, 3]
	static void permutation_re(int[] arr, int[] sel, int k) {
		if (k == sel.length) {// 목적을 이룸, 다 고른 것
			System.out.print(Arrays.toString(sel));
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			sel[k] = arr[i];
			permutation_re(arr, sel, k + 1);
		}

//		sel[k]=arr[idx];
//		permutation_re(arr, sel, 0, k+1);
//		permutation_re(arr, sel, idx+1, k);
	}


	// 지금까지 depth가 내려오면서 한번이라도 골랐던 친구는 배제 [1, 2][1, 3][2, 1][2, 3][3, 1][3, 2]
	static void permutation(int[] arr, int[] sel,int k, boolean[] visited) {
		//지금까지 선택한 원소들이 체크되어있는 배열
		if(k == sel.length) {
			System.out.print(Arrays.toString(sel));

			return;
		}
		for(int i =0; i< arr.length; i++) {
			if(visited[i])continue;
			sel[k] =arr[i];
			visited[i]= true;
			permutation(arr, sel, k+1, visited);
			visited[i]= false;
			
		}
		
		
	}

	static void powerset(int[] arr, boolean[] sel, int idx) {
		if (idx == arr.length) {
			for (int i = 0; i < sel.length; i++) {
				if (sel[i]) {
					System.out.print(arr[i]);
				}
			}
			System.out.println();
			return;
		}
		sel[idx] = true;
		powerset(arr, sel, idx + 1);
		sel[idx] = false;
		powerset(arr, sel, idx + 1);
	}

	static void recur(int[] arr, int idx) {
		if (idx == arr.length) { // 기저파트
			return;

		}
		System.out.println(arr[idx]);
		recur(arr, idx + 1); // 재귀호출영역

	}
}
