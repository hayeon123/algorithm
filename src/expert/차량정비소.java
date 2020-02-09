package expert;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 차량정비소 {
	static int N, M, K, A, B;
	static int[] take;
	static int[] fix;
	static PriorityQueue<Pos> client;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			A = sc.nextInt();
			B = sc.nextInt();
			take = new int[N+1];
			fix = new int[M+1];
			for (int i = 1; i <= N; i++) {
				take[i] = sc.nextInt();
			}
			for (int i = 1; i <= M; i++) {
				fix[i] = sc.nextInt();
			}
			
			result = 0;
			client = new PriorityQueue<>();
			PriorityQueue<Wait> wait = new PriorityQueue<>();
			for (int i = 0; i < K; i++) {
				client.add(new Pos(i + 1, sc.nextInt()));
			}
			int do_take[] = new int[N+1];
			int do_fix[] = new int[M+1];
			Pos p;
			Wait w; 
			for (int i = 0; i < K; i++) {
				p = client.poll();
//				System.out.print(p.time+" ");
				
				out : while (true) {
					for (int j = 1; j <= N; j++) {
						if (do_take[j] <= p.time) {
							do_take[j] = p.time + take[j];
							p.time = do_take[j];
							wait.add(new Wait(p.time, p.idx, j));
//							System.out.println(p.time+" "+j);
							break out;
						}
					}
					p.time++;
				}
				
			}
			for (int i = 0; i < K; i++) {
				w = wait.poll();
				out: while(true) {
					for (int j = 1; j <=M; j++) {
						if(do_fix[j]<=w.time) {
							do_fix[j]= w.time+fix[j]; 
							if(w.num== A && j==B) {
								result+=w.idx;
							}
							break out;
						}
					}
					w.time++;
				}
			}
			if(result ==0)System.out.println("#"+tc+" -1");
			else
			System.out.println("#" + tc + " " + result);
		}
	}
	static class Wait implements Comparable<Wait>{
		int time , idx, num; 
		Wait(int time, int idx, int num){
			this.time = time; 
			this.idx = idx; 
			this.num = num; 
		}
		@Override
		public int compareTo(Wait o) {
			if(this.time== o.time) {
				return this.num - o.num;
			}
			return this.time-o.time;
		}
		
	}
	static class Pos implements Comparable<Pos> {
		int idx, time;

		Pos(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}

		@Override
		public int compareTo(Pos o) {
			if (this.time == o.time) {
				return this.idx - o.idx;
			}
			return this.time - o.time;
		}

	}
}
