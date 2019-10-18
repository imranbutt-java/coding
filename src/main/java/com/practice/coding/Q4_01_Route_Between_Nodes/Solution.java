package com.practice.coding.Q4_01_Route_Between_Nodes;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		Node root = new Node("r", 2);
		Node a = new Node("a", 1);
		Node b = new Node("b", 1);
		
		a.addAdjacent(root);
		b.addAdjacent(root);
		root.addAdjacent(a);
		root.addAdjacent(b);
		
		routeBetweenNodes(a, b).stream().forEach(n -> System.out.println(n.getVertex()));
		
	}
	
	public static List<Node> routeBetweenNodes(Node a, Node b) {
		List<Node> result = new ArrayList<>();
		Node[] adjNodesOfA = a.getAdjacent();
		boolean nodeFound = false;
		int numberOfNodes = -1;
		for(Node n: adjNodesOfA) {
			for(Node m: n.getAdjacent()) {
				if(nodeFound) {
					result.add(b);
					return result;
				}
				if(numberOfNodes < 0) {
					numberOfNodes = m.adjacentCount -1;
					result = new ArrayList<>();
				}
				
				result.add(m);
				numberOfNodes--;
				
				if(m.getVertex().equals(b)) nodeFound = true;
			}
			
		}
		return result;
	}
}
