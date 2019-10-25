package com.practice.coding.tree;

public class FlattenBinaryTreeInLinkedList {
	private Node prev = null;
	
	public static void main(String[] args) {
		FlattenBinaryTreeInLinkedList a = new FlattenBinaryTreeInLinkedList();
		a.solve();
	}
	
	public void solve() {
		Node root = new Node(1);
		root.left = new Node(2);	
		root.right = new Node(5);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.right = new Node(6);
		root.right.left = new Node(100);
		
		flatten(root);
		System.out.println(root);
	}

    public void flatten(Node root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
	    
        root.right = prev;		// previous is the previous root, the subtree's root
        root.left = null;
        prev = root;			
    }
    
    class Node {
    	Node left;
    	Node right;
    	int val;
    	Node(int val) {
    		this.val = val;
    	}
    }
}
