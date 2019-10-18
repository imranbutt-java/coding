package com.practice.coding.tree;

import com.practice.coding.arraytobinary.BTreePrinter;
import com.practice.coding.arraytobinary.Node;

class BinaryTree {
	Node root;

	/* Function to get the maximum width of a binary tree */
	int getMaxWidth(Node node) {
		int maxWidth = 0;
		int width;
		int h = height(node);
		int i;

		/*
		 * Get width of each level and compare the width with maximum width so
		 * far
		 */
		for (i = 1; i <= h; i++) {
			width = getWidth(node, i);
			if (width > maxWidth)
				maxWidth = width;
		}

		return maxWidth;
	}

	/* Get width of a given level */
	int getWidth(Node node, int level) {
		if (node == null)
			return 0;

		if (level == 1)
			return 1;
		else if (level > 1)
			return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
		return 0;
	}

	/* UTILITY FUNCTIONS */

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	int height(Node node) {
		if (node == null)
			return 0;
		else {
			/* compute the height of each subtree */
			int lHeight = height(node.left);
			int rHeight = height(node.right);

			/* use the larger one */
			return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1);
		}
	}

	/* Method to calculate the diameter and return it to main */
    int diameter(Node root)
    {
        /* base case if tree is empty */
        if (root == null)
            return 0;
 
        /* get the height of left and right sub trees */
        int lheight = maxHeight(root.left);
        int rheight = maxHeight(root.right);
 
        /* get the diameter of left and right subtrees */
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);
 
        /* Return max of following three
          1) Diameter of left subtree
         2) Diameter of right subtree
         3) Height of left subtree + height of right subtree + 1 */
        return Math.max(lheight + rheight + 1,
                        Math.max(ldiameter, rdiameter));
 
    }
 
    /* A wrapper over diameter(Node root) */
    int diameter()
    {
        return diameter(root);
    }
 
    /*The function Compute the "height" of a tree. Height is the
      number f nodes along the longest path from the root node
      down to the farthest leaf node.*/
    static int maxHeight(Node node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;
 
        /* If tree is not empty then height = 1 + max of left
           height and right heights */
        return (1 + Math.max(maxHeight(node.left), maxHeight(node.right)));
    }
	
	/* Driver program to test above functions */
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();

		/*
		 * Constructed bunary tree is: 1 / \ 2 3 / \ \ 4 5 8 / \ 6 7
		 */
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.right.left = new Node(5);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(8);
		tree.root.right.right.left = new Node(6);
		tree.root.right.right.right = new Node(7);
		
		BTreePrinter.printNode(tree.root);

		System.out.println("Maximum width is " + tree.getMaxWidth(tree.root));
		System.out.println("The diameter of given binary tree is : "
                + tree.diameter());
	}
}

