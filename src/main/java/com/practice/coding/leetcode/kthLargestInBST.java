package com.practice.coding.leetcode;

public class kthLargestInBST {
	static int counter = 0;
	Tree result = new Tree(0);
	int kthLargestInBST(Tree<Integer> t, int k) {
		if (t == null)
			return 0;
		counter = 0;
		kthLargestInBST1(t, k);
		return (int) result.value;
	}

	void kthLargestInBST1(Tree<Integer> t, int k) {
		if (t == null || counter >= k) {
			return;
		}

		kthLargestInBST1(t.left, k);
		counter++;
		if (k == counter) {
			System.out.println("Node: "+t.value);
			result = t;
		}
			
		kthLargestInBST1(t.right, k);
	}
	
	public static void main(String[] args) {
		Tree r = new Tree(1);
		Tree l = new Tree(-1);
		Tree l1 = new Tree(-2);
		Tree r1 = new Tree(0);
		
		l.left = l1;
		l.right = r1;
		r.left = l;
		
		kthLargestInBST c = new kthLargestInBST();
		System.out.println(c.kthLargestInBST(r, 1));
	}
}

class Tree<T> {
	Tree(T x) {
		value = x;
	}

	T value;
	Tree<T> left;
	Tree<T> right;
}
