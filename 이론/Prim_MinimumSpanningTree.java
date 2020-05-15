package 이론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
//최소스패닝 트리 
public class Prim_MinimumSpanningTree {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		//각 노드의 연결상태를 저장 ,각 배열 초기화 
		ArrayList<Node>[] list = new ArrayList[V+1];
		for (int i = 1; i < list.length; i++) {
			list[i]= new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(a, b, c));
			list[b].add(new Node(b, a, c));
		}
		// 선택된 노드들의 방문배열 
		boolean visited[]= new boolean[V+1];// 정점이 1부터 시작하므로 
		// 간선의 cost가 낮은 순으로 뽑히도록 PriorityQueue사용 
		PriorityQueue<Node> pq = new PriorityQueue<>();
		// 노드들을 기억하도록 Queue사용 
		Queue<Integer> node = new LinkedList<>();
		
		//임의의 노드 선택, 여기서는 1번 선택 
		node.add(1);
		long ans = 0;
		
		//선택할 노드가 없을 때까지 
		while(!node.isEmpty()) {
			//출발 노드 선택 
			int start = node.poll(); 
			// 방문 체크 
			visited[start]=true; 
			// 출발 노드와 연결된 간선들을 pq에 저장 
			for (int i = 0; i < list[start].size(); i++) {
				pq.add(list[start].get(i));
			}
			
			//pq내부에 값이 없을 때까지 
			while(!pq.isEmpty()) {
				//간선의 cost가 가장 작은 노드 선택 
				Node tmp = pq.poll();
				// 도착 노드에 이미 방문 했다면 continue 
				if(visited[tmp.to])continue; 
				//방문하지 않았다면 visited 
				visited[tmp.to]=true; 
				//간선의 cost 
				ans+=tmp.cost;
				// 도착 노드를 노드 큐에 저장 
				node.add(tmp.to);
				break;
			}
		}
		
		System.out.println(ans);
		
	}
	// 정점과 간선에 대한 정보 
	public static class Node implements Comparable<Node>{
		int from, to, cost; 
		Node(int from, int to, int cost){
			this.from= from; 
			this.to = to; 
			this.cost = cost;
		}
		//비용이 적은 순서대로 poll되도록 준
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
}

/*
 * 정점중 아무 시작 정점을 고른다 해당 정점에 연결된 모든 간선 중 가장 최소 비용을 가진 간선을 선택해서 연결한다. 처음 고른 정점과
 * 선택된 간선에 연결된 정점까지 모든 연결된 정점에 연결된 간선 중 가장 비용이 작은 간선을 선택해 정점을연결한다.
 * 
 * 
 */

/*
 * input 정점의 개수, 간선의 개수 
 7 11
 1 2 2 2 3 5 1 3 20 1 4 10 4 5 1 5 6 23 3 6 3 3 5 6
 7 6 9 7 3 2 2 7 7
 * 
 * 
 */