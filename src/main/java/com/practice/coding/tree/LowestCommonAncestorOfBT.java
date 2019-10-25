package com.practice.coding.tree;

public class LowestCommonAncestorOfBT {
	public static void main(String[] args) {
		
	}
	
	public void lowestCommonAnsc() {
		lowestCommonAnsc();
	}
	
	public LCANode lowestCommonAnsc(LCANode root, LCANode a, LCANode b) {
		if(root == null || a == null || b == null) {
			return null;
		}

		LCANode l = lowestCommonAnsc(root.left, a, b);
		LCANode r = lowestCommonAnsc(root.right, a, b);
		
		if(l == null || r == null)
			return root;
		
		return l == null ? r : l;
	}
}

class LCANode {
	LCANode left;
	LCANode right;
	int data;
	LCANode(int d) {
		this.data = d;
	}
}
