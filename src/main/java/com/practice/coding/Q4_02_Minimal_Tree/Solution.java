package com.practice.coding.Q4_02_Minimal_Tree;

import com.practice.coding.book.library.TreeNode;

public class Solution {
	public static void main(String[] args) {
		int[] a = {0,1,2,3,4,5,6};
		
		TreeNode r = convertToBST(a);
		System.out.println(r);
	}
	
	static TreeNode convertToBST(int[] a) {
		return convertToBST(a, 0, a.length-1);
	}
	
	static TreeNode convertToBST(int[] a, int start, int end) {
		if(start > end) return null;
		
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(a[mid]);
		n.left = convertToBST(a, start, mid-1);
		n.right = convertToBST(a, mid+1, end);
		
		return n;
	}
}
