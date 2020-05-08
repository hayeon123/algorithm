import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 톱니바퀴 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] gear = new char[4][8];
		for (int i = 0; i < gear.length; i++) {
			gear[i] = br.readLine().toCharArray();
		}
		int k = Integer.parseInt(br.readLine());
		char[] tmp = new char[8];
		int[] check = new int[4];
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken());
			for (int j = 0; j < check.length; j++) {
				check[j]=0;
			}
			check[num]=d; 
			for (int j = num-1; j >=0; j--) {//왼쪽 
				if(gear[j][2]== gear[j+1][6]) {
					break;
				}
				check[j]=check[j+1]*-1;
			}
			for (int j = num+1; j < check.length; j++) {//오른쪽 
				if(gear[j][6]==gear[j-1][2])break; 
				check[j]=check[j-1]*(-1);
			}
			for (int j = 0; j < check.length; j++) {
				if(check[j]==0)continue; 
				if(check[j]==1) {
					//시계방향
					tmp[0]= gear[j][7];
					for (int j2 = 0; j2 < 7; j2++) {
						tmp[j2+1]= gear[j][j2];
					}
					for (int j2 = 0; j2 < 8; j2++) {
						gear[j][j2]=tmp[j2];
					}
				}else if(check[j]==-1) {
					//반시계방향 
					tmp[7] =gear[j][0];
					for (int j2 = 1; j2 < 8; j2++) {
						tmp[j2-1]=gear[j][j2];
					}
					for (int j2 = 0; j2 < 8; j2++) {
						gear[j][j2]=tmp[j2];
					}
				}
			} 
//			for (int j = 0; j < check.length; j++) {
//				System.out.println(Arrays.toString(gear[j]));
//			}
		}
		
		int ans =0; 
		if(gear[0][0]=='1')ans+=1; 
		if(gear[1][0]=='1')ans+=2; 
		if(gear[2][0]=='1')ans+=4; 
		if(gear[3][0]=='1')ans+=8; 
		System.out.println(ans);
	}
}
