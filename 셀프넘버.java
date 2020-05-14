
public class 셀프넘버 {
	public static void main(String[] args) {
		boolean[] arr = new boolean[10001];
		for(int i =1; i<arr.length; i++) {
			int a = i/10000; 
			int b = (i%10000)/1000;
			int c = (i%1000)/100;
			int d= (i%100)/10; 
			int e = i%10;
			int sum = a+b+c+d+e;
			if(i+sum<=10000) {
				arr[i+sum]=true;
			}
		}
		for(int i =1; i<arr.length; i++) {
			if(!arr[i])System.out.println(i);
		}
	}
	
}
