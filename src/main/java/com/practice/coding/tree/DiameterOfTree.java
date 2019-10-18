package com.practice.coding.tree;

public class DiameterOfTree {
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.left.right = new Node(7);
		root.left.left.left = new Node(8);

		DiameterOfTree d = new DiameterOfTree();
		System.out.println("Diameter of Tree: "+ d.getDiameter(root));
	}
	
	public int getHeight(Node root) {
		if(root == null) return 0;
		return Math.max(root.data+getHeight(root.left), root.data+getHeight(root.right));
	}
	
	public int getDiameter(Node root) {
		if(root!=null) {
			int leftHeight = getHeight(root.left);
			int rightHeight = getHeight(root.right);
			
			int leftDiameter = root.data+getDiameter(root.left);
			int rightDiameter = root.data+getDiameter(root.right);
			
			return Math.max(leftHeight + rightHeight+ 1, Math.max(leftDiameter, rightDiameter));
		}
		
		return 0;
	}
	
	
}


class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}
}
