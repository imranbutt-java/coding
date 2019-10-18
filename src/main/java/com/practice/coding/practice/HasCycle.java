package com.practice.coding.practice;

import java.util.LinkedList;

public class HasCycle {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node lhr = new Node(2);
        Node karachi = new Node(2);
        Node peshawar = new Node(2);
        Node sialkot = new Node(2);

        root.next = lhr;
        lhr.next = karachi;
        karachi.next = peshawar;
        peshawar.next = sialkot;
        sialkot.next = peshawar;
        
        System.out.println(hasCycle(root));

    }

    private static boolean hasCycle(Node root) {
        if(root == null)
            return false;
        Node fast = root.next;
        Node slow = root;

        while (fast != null && slow != null && fast.next != null) {
            if(fast.equals(slow)) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}