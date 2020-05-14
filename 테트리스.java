import java.util.Scanner;

public class 테트리스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt(); 
		int P = sc.nextInt(); 
		int[] map = new int[C];
		for (int i = 0; i < map.length; i++) {
			map[i]=sc.nextInt();
		}
		int ans =0; 
		switch (P) {
		case 1:
			ans+=C; 
			for (int i = 0; i < map.length-4; i++) {
				int tmp =map[i]; 
				boolean check = true; 
				for (int j = i+1; j < i+4; j++) {
					if(tmp!=map[j]) {
						check= false; 
						break; 
					}
				}
				if(check) {
					ans++; 
				}
			}
			break;
		case 2:
			for (int i = 1; i < map.length; i++) {
				if(map[i-1]==map[i])ans++; 
			}
			break;
		case 3:
			for (int i = 1; i < map.length; i++) {
				if(map[i-1]==map[i]+1)ans++; 
			}
			for (int i = 1; i < map.length-1; i++) {
				if(map[i-1]==map[i]&& map[i+1]==map[i]+1)ans++; 
			}
			break;
		case 4:
			for (int i = 1; i < map.length; i++) {
				if(map[i-1]==map[i]-1)ans++; 
			}
			for (int i = 1; i < map.length-1; i++) {
				if(map[i-1]==map[i]+1 && map[i+1]==map[i])ans++; 
			}
			break;
		case 5:
			for (int i = 1; i < map.length; i++) {
				if(map[i-1]==map[i]+1) ans++;
				if(map[i-1]==map[i]-1)ans++; 
			}
			for (int i = 1; i < map.length-1; i++) {
				if(map[i-1]==map[i]&& map[i+1]==map[i])ans++;
				if(map[i-1]==map[i]+1 && map[i+1]==map[i]+1)ans++;
			}
			break;
		case 6:
			for (int i = 1; i < map.length-1; i++) {
				if(map[i-1]==map[i] && map[i+1]==map[i])ans++; 
				if(map[i-1]==map[i]-1 &&map[i+1]==map[i])ans++;
			}
			for (int i = 1; i < map.length; i++) {
				if(map[i-1]==map[i])ans++; 
				if(map[i-1]==map[i]+2)ans++;
			}
			break;
		case 7:
			for (int i = 1; i < map.length-1; i++) {
				if(map[i-1]==map[i] && map[i+1]==map[i])ans++; 
				if(map[i-1]==map[i] &&map[i+1]==map[i]-1)ans++;
			}
			for (int i = 1; i < map.length; i++) {
				if(map[i-1]==map[i])ans++; 
				if(map[i-1]==map[i]-2)ans++;
			}
			break;
		default:
			break;
		}
		System.out.println(ans);
	}
}
