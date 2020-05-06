import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[4];
		arr[1]=1; 
		arr[2]=2; 
		arr[3]=3; 
		//arr[번호]= 자리 
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int tmp = arr[k];
			arr[k]=arr[l];
			arr[l]=tmp;
//			System.out.println(Arrays.toString(arr));
		}
		
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]==1) {System.out.println(i);
			return;
			}
		}
		System.out.println(-1);
	}
}
