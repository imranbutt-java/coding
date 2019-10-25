package com.practice.coding.common;

public class BinaryTreeTraversal {
    Node root;

    public static void main(String[] args) {
        BinaryTreeTraversal tree = new BinaryTreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder();

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();
    }

    // Wrappers over above recursive functions
    void printInorder()    {     printInorder(root);   }
    void printPreorder()   {     printPreorder(root);  }
    void printPostorder()  {     printPostorder(root);  }

    private void printInorder(Node root) {
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.val+" ");
        printInorder(root.right);
    }

    private void printPreorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    private void printPostorder(Node root) {
        if(root == null) {
            return;
        }

        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.val+" ");
    }
}

class Node {
    int val;
    Node left;
    Node right;
    Node(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
