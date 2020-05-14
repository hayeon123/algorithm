package expert;

import java.util.ArrayList;
import java.util.Arrays;

public class 쿠팡1 {
	public static void main(String[] args) {
		int n = 5; //6개 
		int min_position = -5; 
		int max_position= 3; 
		int[] positions= {-1,-3,3}; 

//		int n = 6;
//		int min_position = -10;
//		int max_position = 10;
//		int[] positions = { 6, -10, 2, -6 };

		int x = (Math.abs(min_position) + Math.abs(max_position));
		if (x % n >= 0) {
			x = (x / n) + 1;
		} else {
			x = (x / n);
		}

		Arrays.sort(positions);

		int idx = 0;

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = min_position; i <= max_position; i += x) {

			if (idx < positions.length) {
				if (i == positions[idx]) {
					idx++;
				} else if (i < positions[idx]) {
					list.add(i);
				} else if (i > positions[idx]) {

				}
			}else {
				list.add(i);
			}
		}
		System.out.println(list.toString());

	}
}
