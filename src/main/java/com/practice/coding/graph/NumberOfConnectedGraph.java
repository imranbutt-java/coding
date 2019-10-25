package com.practice.coding.graph;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 323. Number of Connected Components in an Undirected Graph
 * 
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]

     0          3
     |          |
     1 --- 2    4 

Output: 2
 * @author imransarwar
 *
 */
public class NumberOfConnectedGraph {
	public int countComponents(int n, int[][] edges) {
		// As I heard about connected graph, so it looks like some union find problem
		int[] parent = new int[n];
		for(int i=0; i<n; i++)
			parent[i] = i;
		
		for(int[] edge: edges) {
			if(find(edge[0], parent) != find(edge[1], parent)) {
				parent[edge[0]] = parent[edge[1]];
				n--;
			}
		}
		
		return n;
	}

	private int find(int i, int[] parent) {
		if(parent[i] == i)
			return parent[i];
		parent[i] = find(parent[i], parent);
		return parent[i];
	}
	
	public static void main(String args[]) {
		NumberOfConnectedGraph c = new NumberOfConnectedGraph();
		System.out.println(c.countComponents(5, new int[][] {{0,1}, {1,2}, {3,4}}));
		
	}
}
