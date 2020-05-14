import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] AA = st.nextToken().toCharArray();
		char[] BB = st.nextToken().toCharArray();
		int len = BB.length - AA.length;
		int min = 987654321;
		out : for (int i = 0; i <= len; i++) {
			int cnt = 0; 
			for (int j = i; j < i+AA.length; j++) {
				if(AA[j-i]!=BB[j])cnt++; 
				if(cnt>min)continue out;
			} 
			min= Math.min(min, cnt);
		}
		System.out.println(min);
	}
}
