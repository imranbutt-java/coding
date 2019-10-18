package com.practice.coding;

public class LinkedListReverse {
	public static void main(String[] args) {
		LinkedListReverse a = new LinkedListReverse();
		a.solve();
	}
	
	public void solve() {
		Node root = new Node(1);
		root.next = new Node(4);
		root.next.next = new Node(3);
		reverse(root,null);
		
		System.out.println(t);
	}
	
	Node t;
	public Node reverse(Node root, Node prev) {
			
		if(root.next == null){
			t = root;
			root.next = prev;
			return null;
		}

		Node tmp = root.next;
		root.next = prev;
		reverse(tmp, root);
		return t;
	}
	
	class Node {
		Node next;
		int val;
		Node(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return ""+val;
		}
	}
}
