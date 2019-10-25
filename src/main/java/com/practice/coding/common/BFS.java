package com.practice.coding.common;

import java.util.*;

public class BFS {
    static class Node {
        int data;
        boolean isVisited;
        List<Node> child = new ArrayList<>();
        Node(int data) {
            this.data = data;
        }

        public Node getUnvisitedChid() {
            Optional<Node> node = child.stream().filter(i -> i.isVisited == false).findAny();
            if(node.isPresent()) {
                return node.get();
            }
            return null;
        }

        @Override
        public String toString() {
            return ""+this.data;
        }
    }

    public static void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.isVisited = true;
        System.out.println(root);

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            Node child = null;
            while((child = node.getUnvisitedChid()) != null) {
                queue.add(child);
                child.isVisited = true;
                System.out.print(child);
            }
        }
    }

    public static void DFS(Node root) {
        Stack<Node> stack = new Stack<>();
        root.isVisited = true;
        System.out.println(root);
        stack.push(root);

        while(!stack.isEmpty()) {
            Node node = stack.peek();
            Node child = node.getUnvisitedChid();

            if(child != null) {
                child.isVisited = true;
                System.out.print(child);
                stack.push(child);
            } else {
                stack.pop();
            }

        }
    }

    public static void main(String[] args) {
        Node node = new Node(2);
        Node a = new Node(3);
        Node b = new Node(4);
        Node d = new Node(5);

        a.child.add(d);

        node.child.add(a);
        node.child.add(b);
//        BFS(node);
        System.out.println();
        System.out.println("DFS: Started");
        DFS(node);
    }
}
