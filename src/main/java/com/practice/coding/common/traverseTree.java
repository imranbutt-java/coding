package com.practice.coding.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class traverseTree {
	public static void main(String[] args) {
		Tree<Integer> node = new Tree(1);
		Tree<Integer> left = new Tree(2);
		Tree<Integer> right1 = new Tree(3);
		Tree<Integer> right = new Tree(4);
		Tree<Integer> right2 = new Tree(5);

		right.right = right2;
		left.right = right1;
		node.left = left;
		node.right = right;

		System.out.println(traverseTree(node));
		System.out.println(bfs(node));
		
		List<String> list = new ArrayList<>();
		list.add("ab");
		list.add("abc");
		list.add("abd");
//		list.add("abee");
		
		System.out.println(Collections.max(list, Comparator.comparing(s -> s.length())));

	}

	static int[] traverseTree(Tree<Integer> t) {
		List<Integer> list = new ArrayList<>();
		if (t == null) {
			return new int[0];
		}

		// keep the nodes in the path that are waiting to be visited
		Stack<Tree> stack = new Stack<Tree>();
		Tree node = t;

		// first node to be visited will be the left one
		while (node != null) {
			stack.push(node);
			node = node.left;
		}

		// traverse the tree
		while (stack.size() > 0) {

			// visit the top node
			node = stack.pop();
			System.out.print(node.value + " ");
			list.add((Integer) node.value);
			if (node.right != null) {
				node = node.right;

				// the next node to be visited is the leftmost
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
		}
		return list.stream().mapToInt(i -> i).toArray();

	}

	static int[] bfs(Tree<Integer> t) {
		Queue<Tree> queue = new LinkedList<Tree>();
		List<Integer> list = new ArrayList<>();
		if (t == null)
			return new int[0];
		queue.clear();
		queue.add(t);
		while (!queue.isEmpty()) {
			Tree node = queue.remove();
			System.out.print(node.value + " ");
			list.add((Integer) node.value);
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
		
		return list.stream().mapToInt(i -> i).toArray();
	}
}
