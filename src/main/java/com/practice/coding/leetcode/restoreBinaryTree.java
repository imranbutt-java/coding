package com.practice.coding.leetcode;

public class restoreBinaryTree {
	
	public static void main(String[] args) {
		int[] a = {4, 2, 1, 5, 3, 6};
		int[] b = {1, 2, 4, 3, 5, 6};
		Tree<Integer> tree = restoreBinaryTree(a, b);
		System.out.println(tree);
	}
	
	static Tree<Integer>  restoreBinaryTree(int[] inorder, int[] preorder) {
		return buildTree0(preorder, 0, preorder.length, inorder, 0, inorder.length);
	}

	@SuppressWarnings("unchecked")
	private static Tree<Integer> buildTree0(int[] preorder, int ipre, int jpre, int[] inorder, int iin, int jin) {
		if (jpre <= ipre || jin <= iin)
			return null;
		Tree root = new Tree(preorder[ipre]);
		int i = iin;
		for (; i < jin; i++) {
			if (inorder[i] == preorder[ipre])
				break;
		}
		root.left = buildTree0(preorder, ipre + 1, ipre + 1 + i - iin, inorder, iin, i);
		root.right = buildTree0(preorder, ipre + 1 + i - iin, jpre, inorder, i + 1, jin);
		return root;
	}
}
