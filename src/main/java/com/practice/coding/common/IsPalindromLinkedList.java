package com.practice.coding.common;

import java.util.Stack;

public class IsPalindromLinkedList {
	public boolean isPalindrom(Node node) {
		if(node == null || node.next == null)
			return true;
		
		Stack<Node> stack = new Stack<>();
		
		Node fast = node;
		Node slow = node;
		
		while(fast != null && fast.next != null) {
			stack.push(slow);
			fast = fast.next.next;
			slow = slow.next;
		}
		
		//For Even numbers
		if(fast.next != null) {
			slow = slow.next;
		}
		
		while(!stack.isEmpty()) {
			if(stack.pop().val != slow.val) return false;
			slow = slow.next;
		}
		return true;
	}
	
	class Node {
		Node next;
		int val;
		Node(int val) {
			this.val = val;
		}
	}
}


