package com.practice.coding.common;

public class LowestCommonAncestorOfBT {
	public static void main(String[] args) {
		
	}
	
	public void lowestCommonAnsc() {
		lowestCommonAnsc();
	}
	
	public Node lowestCommonAnsc(Node root, Node a, Node b) {
		if(root == null || a == null || b == null) {
			return null;
		}
		
		Node l = lowestCommonAnsc(root.left, a, b);
		Node r = lowestCommonAnsc(root.right, a, b);
		
		if(l == null || r == null)
			return root;
		
		return l == null ? r : l;
	}
}

class Node {
	Node left;
	Node right;
	int data;
	Node(int d) {
		this.data = d;
	}
}
