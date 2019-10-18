package com.practice.coding.geekofgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RemoveAllLeaves {
	public static void main(String[] args) {
		/*
		 * Constructed bunary tree is: 4 
		 * 							  / \ 
		 * 							 2       7
		 * 							/ \     / \ 
		 * 						   1   3   6   8
		 * 										\
		 * 										 9 
		 * 								   
		 */
		
		IntTreeNode root = new IntTreeNode(0);
		root = new IntTreeNode(4);
		root.left = new IntTreeNode(2);
		root.right = new IntTreeNode(7);
		root.left.left = new IntTreeNode(1);
		root.left.right = new IntTreeNode(3);
		root.right.right = new IntTreeNode(8);
		root.right.left = new IntTreeNode(6);
		root.right.right.right = new IntTreeNode(9);
		
		RemoveAllLeaves r = new RemoveAllLeaves();
//		IntTreeNode result = r.removeLeaves(root);
//		System.out.println(result);
		
		System.out.println(r.largestNum(root, 0));
	}
	
	public IntTreeNode removeLeaves(IntTreeNode root) {
		if(root == null)
			return null;
	    if (root != null && root.left == null && root.right == null) {
	        return null;
	    }
	    root.left = removeLeaves(root.left);
	    root.right = removeLeaves(root.right);
	    return root;
	}
	
	List<Integer> s = new ArrayList<>();
	int largestNum(IntTreeNode root, int num) {
		if(root == null) return -1;
		
		if(root.data <= num) {
			s.add(root.data);
			largestNum(root.right, num);
			
		} else {
			largestNum(root.left, num);
		}
		return s.isEmpty()?-1:Collections.max(s);
	}
	
	boolean isInorder(int[] arr) {
		if(arr == null || arr.length == 1) return true;
		
		for(int i=1; i<arr.length; i++)
			if(arr[i-1] > arr[i])
				return false;
		return true;
	}
}

class IntTreeNode {
    public int data;
    public IntTreeNode left;
    public IntTreeNode right;

    // constructs a leaf node with given data
    public IntTreeNode(int data) {
        this(data, null, null);
    }

    // constructs a branch node with given data, left subtree,
    // right subtree
    public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
