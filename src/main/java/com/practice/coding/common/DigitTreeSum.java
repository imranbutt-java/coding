package com.practice.coding.common;

public class DigitTreeSum {
	static long num = 0;
	static long fNum = 0;
	static long digitTreeSum(Tree<Integer> t) {
	    if(t == null) return 0;
	    return digitTreeSum(t, 1);
	}

	static long digitTreeSum(Tree<Integer> t, long deci) {
	    if(t == null) {
	    	return num;
	    }
	    
//	    int d = 1;
//	    for(int i=1; i<deci; i++) {
//	    	d =+d * 10;
//	    }
	    num *= 10 ;
	    num = num + t.value;
	    t.value = (int)num;
	    num = digitTreeSum(t.left, ++deci);
	    num += num;
	    num = digitTreeSum(t.right, ++deci);
	    
	    return num; 
	}
	
	public static void main(String[] args) {
		Tree<Integer> node = new Tree(1);
		Tree<Integer> left = new Tree(0);
		Tree<Integer> left1 = new Tree(3);
		Tree<Integer> right1 = new Tree(1);
		Tree<Integer> right = new Tree(4);

		left.right = right1;
		left.left = left1;
		node.left = left;
		node.right = right;
		
		System.out.println(digitTreeSum(node));
		System.out.println(fNum);
	}
}
