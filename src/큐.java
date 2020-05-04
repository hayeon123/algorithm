package algorithm;

import java.util.Scanner;

public class ť {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int N = sc.nextInt(); 
		Queue que = new Queue();
		
		for(int i=0; i<N; i++) {
			String str = sc.next(); 
			switch (str) {
			case "push":
				int x = sc.nextInt(); 
				que.push(x);
				break;
			case "pop":
				System.out.println(que.pop());
				break;
			case "size":
				System.out.println(que.size());
				break;
			case "empty":
				if(que.empty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				break;
			case "front":
				System.out.println(que.front());
				break;
			case "back":
				System.out.println(que.back());
				break;

			default:
				break;
			}
		}
	}

	static class Node {
		Node pre;
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	static class Queue {
		Node head;
		Node tail;

		Queue() {
			this.head = null;
			this.tail = null;
		}

		boolean empty() {
			if (head == null && tail == null)
				return true;
			else
				return false;
		}
		void push(int x) {
			Node node = new Node(x);
			if(this.empty()) {
				this.head= node; 
				this.tail = node; 
			}else {
				node.pre = this.tail; 
				tail.next = node;
				this.tail = node; 
			}
		}
		int pop() {
			if(this.empty()) {
				return -1; 
			}
			int x = this.head.data; 
			this.head = this.head.next; 
			if(this.head== null) {
				this.tail= null; 
			}
			return x; 
		}
		int size() {
			Node node = this.head;
			int cnt =0; 
			while(node!=null) {
				cnt++; 
				node= node.next; 
			}
			return cnt; 			
		}
		int front() {
			if(this.empty()) {
				return -1;
			}
			return this.head.data;
		}
		int back() {
			if(this.empty())return -1; 
			return this.tail.data; 
		}

	}
}
