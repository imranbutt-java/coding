package com.practice.coding.Introduction;

import com.practice.coding.book.library.TreeNode;

public class Traversals {
	public static void visit(TreeNode node) {
		if (node != null) {
			System.out.print(""+node.data+",");
		}
	}

	/**
	 * Left Root Right /`\
	 * @param node
	 */
	public static void inOrderTraversal(TreeNode node) {
		if (node != null) {
			inOrderTraversal(node.left);
			visit(node);
			inOrderTraversal(node.right);
		}
	}

	/**
	 * Root Left Right /_
	 * @param node
	 */
	public static void preOrderTraversal(TreeNode node) {
		if (node != null) {
			visit(node);
			inOrderTraversal(node.left);
			inOrderTraversal(node.right);
		}
	}

	/**
	 * Left Right Root _\
	 * @param node
	 */
	public static void postOrderTraversal(TreeNode node) {
		if (node != null) {
			inOrderTraversal(node.left);
			inOrderTraversal(node.right);
			visit(node);
		}
	}	
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// We needed this code for other files, so check out the code in the library
		TreeNode root = TreeNode.createMinimalBST(array);
		inOrderTraversal(root);
	}

}
