package expert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class 보물상자비밀번호 {
	static long pow[]=new long[7];
	static int N,K; 
	static long arr[];
	public static void main(String[] args) {
		for (int i = 0; i < 7; i++) {
			pow[i]=(long)Math.pow(16, i);
		}
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 
		for(int tc =1; tc<=T; tc++) {
			N = sc.nextInt(); 
			K= sc.nextInt(); 
			arr = new long[N+(N/4)];
			String str = sc.next();
			for (int i = 0; i < N; i++) {
				if(str.charAt(i)>=65) {
					arr[i]=str.charAt(i)-'A'+10;
				}else {
					arr[i]= str.charAt(i)-'0';
				}
			}
			for (int i = 0; i < N/4; i++) {
				arr[N+i]=arr[i];
			}	
			System.out.println("#"+tc+" "+solution());
		}
			
	}
	static long solution() {
		long result =0; 
		ArrayList<Long> list = new ArrayList<>();
		int p = N/4; 
		for (int j = 0; j < p; j++) {
			long a =0; 
			long b =0; 
			long c = 0; 
			long d =0; 
			int idx =p-1; 
			for (int i = j; i <j+p; i++) {
				a+=arr[i]*pow[idx];
				b+=arr[i+p]*pow[idx];
				c+=arr[i+p+p]*pow[idx];
				d+=arr[i+p+p+p]*pow[idx];
				idx--;
				
			}
			list.add(a);
			list.add(b);
			list.add(c);
			list.add(d);
		}
		list.sort(new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				return (int) (o2-o1);
			}
		});
		long a = -1; 
		int idx =0; 
		for (int i = 0; i < list.size(); i++) {
			if(a== list.get(i))continue; 
			a=list.get(i); 
			idx++;
			if(idx == K) {
				result = list.get(i);
				break;
			}
		}
		return result ; 
	}
}

//1F7 503  
//
//A=10
//B=11
//C=12
//D=13
//E=14
//F=15
