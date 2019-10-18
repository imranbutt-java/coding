package com.practice.coding.arraytobinary;

import java.util.Scanner;

public class ArrayToBinaryTree {
	static Scanner in = new Scanner(System.in);

    static void inorder(Node tree){
        if(tree==null)
            return;
        inorder(tree.left);
        System.out.print(tree.data+"\t");
        inorder(tree.right);
    }

    static void preorder(Node tree){
        if(tree==null)
            return;
        System.out.print(tree.data+"\t");
        preorder(tree.left);
        preorder(tree.right);
    }

    static void postorder(Node tree){
        if(tree==null)
            return;
        postorder(tree.left);
        postorder(tree.right);
        System.out.print(tree.data+"\t");
    }

    static Node cnvrt(int[] ar,int pos){
        if((pos>ar.length-1)||(ar[pos]==-1))
            return null;
        Node tmp = new Node();
        tmp.data = ar[pos];
        tmp.left = cnvrt(ar,2*pos+1);
        tmp.right = cnvrt(ar,2*pos+2);
        return tmp;
    }

    public static void main(String[] args) {
        int len;
        System.out.print("\nEnter length: ");
        len = in.nextInt();
        int[] ar = new int[len];
        int i;
        for(i=0;i<len;i++)
            ar[i] = in.nextInt();
        Node tree = new Node();
        tree = cnvrt(ar,0);
        BTreePrinter.printNode(tree);
        System.out.println("Inorder traversal of the tree is:");
        inorder(tree);
        System.out.println("\nPreorder traversal of the tree is:");
        preorder(tree);
        System.out.println("\nPostorder traversal of the tree is");
        postorder(tree);
    }
}
