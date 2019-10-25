package com.practice.coding.tree;

public class CreateBSTUsingSortedArray {
	public static void main(String[] args) {
		CreateBSTUsingSortedArray a = new CreateBSTUsingSortedArray();
		a.solve();
	}
	
	public void solve() {
		int[] nums = {1,2,3,4};
		Node root = createBST(nums, 0, nums.length-1);
		printNode(root);
	}
	
	void printNode(Node root) {
		if(root == null)
			return;
		System.out.println(root.value);
		printNode(root.left);
		printNode(root.right);
	}
	
	public Node createBST(int[] arr, int min, int max) {
		if(min > max)
			return null;
		
		if(min == max)
			return new Node(arr[min]);
		
		int mid = (min+max)/2;
		Node root = new Node(arr[mid]);
		
		root.left = createBST(arr, min, mid-1);
		root.right = createBST(arr, mid+1, max);
		return root;
	}
	
	class Node {
		Node left;
		Node right;
		int value;
		Node(int val) {
			this.value = val;
		}
	}
}