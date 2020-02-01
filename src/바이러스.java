import java.util.Arrays;
import java.util.Scanner;

public class 바이러스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int INFI = 987654321;
		int com = sc.nextInt();
		int[][] map = new int[com + 1][com + 1];

		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], INFI);
		}
		for (int i = 0; i < map.length; i++) {
			map[i][i] = 0;
		}
		int link = sc.nextInt();
		for (int i = 0; i < link; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
			map[b][a] = 1;
		}
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map.length; j++) {
//				if(map[i][j]==INFI)System.out.print("1 ");
//				else 
//					System.out.print(map[i][j]+" ");
//			}System.out.println();
//		}
		for (int k = 1; k < map.length; k++) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 1; j < map.length; j++) {
//					if(k==j||i==k||j==i)continue;
					if (map[i][j] >= map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
						map[j][i] = map[i][k] + map[k][j];
					}
				}
			}
		}

		int cnt = 0;
		for (int i = 2; i < map.length; i++) {
			if (map[1][i] != INFI)
				cnt++;
		}
		System.out.println(cnt);
	}
}
