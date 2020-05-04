package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Ä«µå {
	public static void main(String[] args) throws NumberFormatException, IOException {
		HashMap<Long, Integer> map = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long max = 0;
		int val = -1;
		for (int i = 0; i < N; i++) {
			long k = Long.parseLong(br.readLine());
			if (map.containsKey(k)) {
				map.put(k, map.get(k) + 1);
			} else {
				map.put(k, 1);
			}
			if (val < map.get(k)) {
				max = k;
				val = map.get(k);
			} else if (val == map.get(k) && k < max) {
				max = k;
			}
		}

		System.out.println(max);
	}
}
