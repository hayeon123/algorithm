
import java.util.Scanner;

public class 덱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		DequeLink link = new DequeLink();
		
		for(int i =0; i<N; i++) {
			String str = sc.next(); 
			switch (str) {
			case "push_front":
				int x = sc.nextInt(); 
				link.push_front(x);
				break;
			case "push_back":
				 x = sc.nextInt(); 
				link.push_back(x);
				break;
			case "pop_front":
				System.out.println(link.pop_front());
				break;
			case "pop_back":
				System.out.println(link.pop_back());
				break;
			case "size":
				System.out.println(link.size());
				break;
			case "empty":
				if(link.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				break;
			case "front":
				System.out.println(link.front());
				break;
			case "back":
				System.out.println(link.back());
				break;

			default:
				break;
			}
			
		}
	}

	static class Deque {
		int data;
		Deque pre;
		Deque next;

		public Deque(int data) {
			this.data = data;
		}

		public Deque() {
		}
	}

	static class DequeLink {
		Deque head;
		Deque tail;

		public DequeLink() {
			this.head = null;
			this.tail = null;
		}

		boolean isEmpty() {
			if (this.head == null && this.tail == null) {
				return true;
			} else {
				return false;
			}
		}

		void push_front(int x) {
			Deque dq = new Deque(x);
			if (this.isEmpty()) {
				this.head = dq;
				this.tail = dq;
			} else {
				this.head.pre=dq;
				dq.next = this.head;
				this.head = dq;
			}
		}

		void push_back(int x) {
			Deque dq = new Deque(x);
			if (this.isEmpty()) {
				this.head = dq;
				this.tail = dq;
			} else {
				this.tail.next=dq;
				dq.pre = this.tail;
				this.tail = dq;
			}
		}

		int pop_front() {
			if(this.isEmpty()) {
				return -1; 
			}else {
				int x = this.head.data; 
				this.head = this.head.next;
				if(this.head!=null)
					this.head.pre=null; 
				else 
					this.tail=null;
				return x;
			}
		}
		
		int pop_back() {
			if(this.isEmpty()) {
				return -1; 
			}
			else {
				int x = this.tail.data; 
				this.tail = this.tail.pre;
				if(this.tail!=null)
					this.tail.next=null; 
				else {
					this.head = null;
				}
				return x;
			}
		}
		int size() {
			int cnt = 1; 
			if(this.isEmpty())return 0;
			
			Deque node = this.head;
			while(node.next!=null) {
				cnt++;
				node= node.next;
			}
			return cnt; 
		}
		int front() { 
			if(this.isEmpty()) {
				return -1; 
			}else {
				return this.head.data;
			}
		}
		int back() {
			if(this.isEmpty()) {
				return -1; 
			}else {
				return this.tail.data;
			}
		}

	}

}
